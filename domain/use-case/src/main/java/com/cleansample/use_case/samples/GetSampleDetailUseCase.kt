package com.cleansample.use_case.samples

import com.cleansample.core.IoDispatcher
import com.cleansample.core.WrappedResult
import com.cleansample.core.cacheMap
import com.cleansample.core.errors.NetworkError
import com.cleansample.core.errors.Timeout
import com.cleansample.core.map
import com.cleansample.domain.entity.SampleEntity
import com.cleansample.domain.repository.SampleRepository
import com.cleansample.use_case.base.UseCase
import com.cleansample.use_case.mapper.mapAddress
import com.cleansample.use_case.mapper.mapAttributes
import com.cleansample.use_case.mapper.mapDate
import com.cleansample.use_case.mapper.mapDocuments
import com.cleansample.use_case.mapper.mapFeatures
import com.cleansample.use_case.mapper.mapPictures
import com.cleansample.use_case.mapper.mapPrice
import com.cleansample.use_case.model.Address
import com.cleansample.use_case.model.Attribute
import com.cleansample.use_case.model.Document
import com.cleansample.use_case.model.Price
import kotlinx.coroutines.CoroutineDispatcher
import timber.log.Timber
import javax.inject.Inject

class GetSampleDetailUseCase @Inject constructor(
    private val sampleRepository: SampleRepository,
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
) : UseCase<Long, GetSampleDetailUseCase.Response>(coroutineDispatcher) {
    override suspend fun execute(parameter: Long): WrappedResult<Response> {
        return sampleRepository
            .getSample(parameter)
            //
            /**
             * Cache just the NetworkError group error types to the use case ones
             * if the NetworkError will be happened, you should map it here and if not, the cursor
             * will carry on with a failure status
             */
            .cacheMap<SampleEntity, NetworkError> { errorType, throwable ->
                if (errorType is Timeout && errorType.time < 50) {
                    WrappedResult.failure(
                        GetSampleDetailUseCaseErrorTypeA, Throwable("TypeAThrowable Timeout"))
                } else {
                    WrappedResult.failure(
                        GetSampleDetailUseCaseErrorTypeB,
                        Throwable("TypeBThrowable $throwable"))
                }
            }
            .map { entity ->
                Response(
                    id = entity.id,
                    description = entity.description,
                    title = entity.title,
                    visits = entity.visits,
                    postedDateTime = mapPostedDateTime(entity),
                    features = entity.features.distinct().mapFeatures(),
                    pictures = entity.pictures.distinct().mapPictures(),
                    attributes = entity.attributes.distinct().mapAttributes(),
                    documents = entity.documents.distinct().mapDocuments(),
                    address = entity.address.mapAddress(),
                    price = entity.price.mapPrice()
                )
            }
    }

    private fun mapPostedDateTime(entity: SampleEntity) = try {
        entity.postedDateTime.mapDate()
    } catch (e: Exception) {
        Timber.e(e)
        "-"
    }

    data class Response(
        val address: Address,
        val attributes: List<Attribute>,
        val description: String,
        val documents: List<Document>,
        val features: List<String>,
        val id: String,
        val pictures: List<String>,
        val postedDateTime: String,
        val price: Price,
        val title: String,
        val visits: Int,
    )

    sealed interface GetSampleDetailUseCaseError

    object GetSampleDetailUseCaseErrorTypeA : GetSampleDetailUseCaseError
    object GetSampleDetailUseCaseErrorTypeB : GetSampleDetailUseCaseError

}


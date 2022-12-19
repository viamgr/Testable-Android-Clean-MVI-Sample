package com.cleansample.feature.sample.presentation.detail

import androidx.lifecycle.SavedStateHandle
import com.cleansample.core.WrappedResult
import com.cleansample.core.errors.BaseError
import com.cleansample.core.errors.NetworkError
import com.cleansample.core.map
import com.cleansample.feature.sample.presentation.mapError
import com.cleansample.presentation.afterEffect
import com.cleansample.presentation.beforeEffect
import com.cleansample.use_case.samples.GetSampleDetailUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class GetSampleDetailResponse @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSampleDetailUseCase: GetSampleDetailUseCase,
) {
    val sampleId: Long = savedStateHandle.get<Long>("sampleId") ?: error(IllegalStateException())
    lateinit var cachedLatitude: String
    lateinit var cachedLongitude: String
    lateinit var cachedPictures: List<String>

    private fun GetSampleDetailUseCase.Response.cacheFields() {
        cachedLatitude = address.latitude
        cachedLongitude = address.longitude
        cachedPictures = pictures
    }

    suspend operator fun invoke(): Flow<SampleDetailEffect> {
        return getSampleDetailUseCase(sampleId)
            .map { value ->
                value.cacheFields()
                SampleDetailEffect.InitEffect(value)
            }
            .let {
                flowOf(it)
            }
            .applyEffects()
    }


    private fun Flow<WrappedResult<out SampleDetailEffect>>.applyEffects(): Flow<SampleDetailEffect> {
        return mapError { errorType: Any, throwable: Throwable ->
            SampleDetailEffect.ErrorEffect(PresentationError(errorType.toString(),
                throwable.toString()))
        }
            .beforeEffect { SampleDetailEffect.LoadingEffect(true) }
            .afterEffect { SampleDetailEffect.LoadingEffect(false) }
    }


    sealed interface GetSampleDetailResponseError

    data class PresentationUseCaseError(val useCaseError: GetSampleDetailUseCase.GetSampleDetailUseCaseError) :
        GetSampleDetailResponseError

    data class PresentationNetworkError(val networkError: NetworkError) :
        GetSampleDetailResponseError

    data class PresentationUnHandledError(val errorType: BaseError) : GetSampleDetailResponseError

}
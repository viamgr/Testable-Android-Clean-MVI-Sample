package com.cleansample.domain.use_case.samples

import com.cleansample.core.WrappedResult
import com.cleansample.core.requireData
import com.cleansample.domain.entity.AddressEntity
import com.cleansample.domain.entity.AttributeEntity
import com.cleansample.domain.entity.DocumentEntity
import com.cleansample.domain.entity.PriceEntity
import com.cleansample.domain.entity.SampleEntity
import com.cleansample.domain.repository.SampleRepository
import com.cleansample.test_shared.dispatcher
import com.cleansample.use_case.model.Address
import com.cleansample.use_case.model.Attribute
import com.cleansample.use_case.model.Document
import com.cleansample.use_case.model.Price
import com.cleansample.use_case.samples.GetSampleDetailUseCase
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk

internal class GetSampleDetailUseCaseShouldSpec : ShouldSpec() {
    private lateinit var sampleRepository: SampleRepository
    private lateinit var target: GetSampleDetailUseCase

    init {

        beforeTest {
            sampleRepository = mockk(relaxed = true)
            target = GetSampleDetailUseCase(sampleRepository, dispatcher)
        }

        should("get sample from repository on success result should return success result") {
            val getSampleFakeResponse = WrappedResult.success(
                SampleEntity
                    (
                    address = AddressEntity(
                        city = "city",
                        latitude = "latitude",
                        longitude = "longitude",
                        street = "street",
                        zipCode = "zipCode"),
                    attributes = listOf(
                        AttributeEntity(
                            label = "label",
                            unit = "unit",
                            value = "value"
                        )
                    ),
                    description = "description",
                    documents = listOf(
                        DocumentEntity(
                            link = "link",
                            title = "title"
                        )
                    ),
                    features = listOf(
                        "features"
                    ),
                    id = "id",
                    pictures = listOf(
                        "pictures1"
                    ),
                    postedDateTime = "2021-10-08T08:01:00.000+0100",
                    price = PriceEntity(
                        amount = 220.0,
                        currency = "currency"
                    ),
                    title = "title",
                    visits = 10
                )
            )
            val expectedResponse = WrappedResult.success(
                GetSampleDetailUseCase.Response(
                    address = Address(
                        city = "city",
                        latitude = "latitude",
                        longitude = "longitude",
                        street = "street",
                        zipCode = "zipCode"),
                    attributes = listOf(
                        Attribute(
                            label = "label",
                            unit = "unit",
                            value = "value"
                        )
                    ),
                    description = "description",
                    documents = listOf(
                        Document(
                            link = "link",
                            title = "title"
                        )
                    ),
                    features = listOf("features"),
                    id = "id",
                    pictures = listOf("pictures1"),
                    postedDateTime = "10.08.2021",
                    price = Price(amount = 220.0, currency = "currency"),
                    title = "title",
                    visits = 10,
                )
            )
            coEvery { sampleRepository.getSample(any()) } returns getSampleFakeResponse
            val result = target.invoke(1)
            expectedResponse.requireData() shouldBe result.requireData()
        }

        should("get sample with error result should return error") {
            val fakeResult = WrappedResult.failure<SampleEntity, Any>(Unit, Exception("Exception"))

            coEvery { sampleRepository.getSample(any()) } returns fakeResult

            val result = target.invoke(1)
            result.isFailure shouldBe true
        }

        afterTest {
            clearAllMocks()
        }

    }

}
package com.cleansample.domain.use_case.samples

import com.cleansample.core.WrappedResult
import com.cleansample.domain.repository.SampleRepository
import com.cleansample.test_shared.dispatcher
import com.cleansample.use_case.samples.GetSampleDetailUseCase
import io.kotest.core.spec.style.FunSpec
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
internal class GetSampleDetailUseCaseFunSpec : FunSpec() {
    private lateinit var sampleRepository: SampleRepository
    private lateinit var target: GetSampleDetailUseCase

    init {

        beforeTest {
            sampleRepository = mockk(relaxed = true)
            target = GetSampleDetailUseCase(sampleRepository, dispatcher)
        }

        test("get sample with parameter should call repository function with correct input") {
            val expected = 10000L
            coEvery { sampleRepository.getSample(expected) } returns WrappedResult.success(mockk(
                relaxed = true))

            GetSampleDetailUseCase(sampleRepository, dispatcher).invoke(expected)

            coVerify { sampleRepository.getSample(expected) }
        }

        afterTest {
            clearAllMocks()
        }

    }

}
package com.cleansample.data.repository

import com.cleansample.core.WrappedResult
import com.cleansample.data.datasource.SampleRemoteDataSource
import com.cleansample.data.datasource.model.SampleModel
import com.cleansample.data.repository.mapper.SampleModelMapper
import com.cleansample.domain.entity.SampleEntity
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.should
import io.kotest.matchers.types.beInstanceOf
import io.mockk.coEvery
import io.mockk.mockk

internal class SampleRepositoryImplShouldSpec : ShouldSpec() {
    private val sampleRemoteDataSource: SampleRemoteDataSource = mockk(relaxed = true)
    private val sampleModelMapper = mockk<SampleModelMapper>(relaxed = true)

    private val target =
        SampleRepositoryImpl(sampleRemoteDataSource, sampleModelMapper)

    override fun isolationMode() = IsolationMode.InstancePerTest

    init {
        should("get sample from data source on success result should return success result") {
            val expected = WrappedResult.success<SampleModel>(mockk())
            val expectedParameter: Long = 1

            coEvery { sampleRemoteDataSource.getSample(expectedParameter) } returns expected

            val result = target.getSample(expectedParameter)
            result should beInstanceOf<WrappedResult<SampleEntity>>()
        }
    }

}
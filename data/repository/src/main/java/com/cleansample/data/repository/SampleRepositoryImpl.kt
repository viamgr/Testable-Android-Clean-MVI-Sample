package com.cleansample.data.repository

import com.cleansample.core.WrappedResult
import com.cleansample.core.map
import com.cleansample.data.datasource.SampleRemoteDataSource
import com.cleansample.data.repository.mapper.SampleModelMapper
import com.cleansample.domain.entity.SampleEntity
import com.cleansample.domain.repository.SampleRepository
import javax.inject.Inject

internal class SampleRepositoryImpl @Inject constructor(
    private val sampleRemoteDataSource: SampleRemoteDataSource,
    private val sampleModelMapper: SampleModelMapper,
) : SampleRepository {
    override suspend fun getSample(sampleId: Long): WrappedResult<SampleEntity> {
        return sampleRemoteDataSource.getSample(sampleId)
            .map {
                sampleModelMapper.map(it)
            }
    }
}
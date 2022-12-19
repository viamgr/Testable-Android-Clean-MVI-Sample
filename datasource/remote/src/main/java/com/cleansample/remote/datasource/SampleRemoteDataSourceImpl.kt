package com.cleansample.remote.datasource

import com.cleansample.core.WrappedResult
import com.cleansample.core.map
import com.cleansample.data.datasource.SampleRemoteDataSource
import com.cleansample.data.datasource.model.SampleModel
import com.cleansample.remote.mapper.SampleResponseMapper
import com.cleansample.remote.request.GetSampleRequest
import javax.inject.Inject

internal class SampleRemoteDataSourceImpl @Inject constructor(
    private val sampleResponseMapper: SampleResponseMapper,
    private val getSampleRequest: GetSampleRequest,
) : SampleRemoteDataSource {
    override suspend fun getSample(sampleId: Long): WrappedResult<SampleModel> {
        return getSampleRequest(sampleId)
            .map {
                sampleResponseMapper.map(it)
            }
    }

}
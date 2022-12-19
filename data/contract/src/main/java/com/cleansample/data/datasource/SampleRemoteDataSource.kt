package com.cleansample.data.datasource

import com.cleansample.core.WrappedResult
import com.cleansample.data.datasource.model.SampleModel

interface SampleRemoteDataSource {
    suspend fun getSample(sampleId: Long): WrappedResult<SampleModel>
}
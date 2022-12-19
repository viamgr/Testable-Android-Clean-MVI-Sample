package com.cleansample.domain.repository

import com.cleansample.core.WrappedResult
import com.cleansample.domain.entity.SampleEntity

interface SampleRepository {
    suspend fun getSample(sampleId: Long): WrappedResult<SampleEntity>
}
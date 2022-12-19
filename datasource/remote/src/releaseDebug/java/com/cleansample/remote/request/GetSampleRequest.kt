package com.cleansample.remote.request

import com.cleansample.core.WrappedResult
import com.cleansample.core.errors.InvalidItemId
import com.cleansample.core.errors.ItemNotFound
import com.cleansample.core.toSuccess
import com.cleansample.remote.api.SampleApi
import com.cleansample.remote.base.BaseRequest
import com.cleansample.remote.response.SampleResponse
import retrofit2.HttpException
import javax.inject.Inject


internal class GetSampleRequest @Inject constructor(
    private val sampleApi: SampleApi,
) : BaseRequest<Long, SampleResponse>() {
    override suspend fun request(params: Long): WrappedResult<SampleResponse> {
        return try {
            return sampleApi.getSample().toSuccess()
        } catch (e: HttpException) {
            when (e.code()) {
                404 -> ItemNotFound(params)
                410 -> InvalidItemId(params)
                else -> null
            }?.let {
                WrappedResult.failure(it, e)
            } ?: error(e)
        }

    }
}
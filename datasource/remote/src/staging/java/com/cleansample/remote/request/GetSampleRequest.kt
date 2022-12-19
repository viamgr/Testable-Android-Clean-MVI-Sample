package com.cleansample.remote.request

import android.content.Context
import com.cleansample.core.WrappedResult
import com.cleansample.core.errors.ItemNotFound
import com.cleansample.core.errors.Timeout
import com.cleansample.core.toSuccess
import com.cleansample.remote.base.BaseRequest
import com.cleansample.remote.response.SampleResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.IOException
import javax.inject.Inject

internal class GetSampleRequest @Inject constructor(@ApplicationContext private val context: Context) :
    BaseRequest<Long, SampleResponse>() {
    override suspend fun request(params: Long): WrappedResult<SampleResponse> {
        val timeMillis = (0..100).random().toLong()
        delay(timeMillis)

        return when (getRandom()) {
            in 1..3 -> {
                throw IOException()
            }
            in 3..5 -> {
                WrappedResult.failure(Timeout(timeMillis.toInt()), Exception())
            }
            in 5..9 -> {
                WrappedResult.failure(ItemNotFound(10), Exception())
            }
            else -> fakeResponse().toSuccess()
        }
    }

    private fun getRandom(): Int {
        return (System.currentTimeMillis() % 10).toInt()
    }

    private fun fakeResponse(): SampleResponse {
        return context.assets.open("sample.json")
            .bufferedReader()
            .use {
                it.readText()
            }.let {
                Json.decodeFromString(it)
            }
    }
}
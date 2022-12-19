package com.cleansample.remote.api

import com.cleansample.remote.response.SampleResponse
import retrofit2.http.GET

internal interface SampleApi {

    @GET("/c1f995088032cf1c62d6")
    suspend fun getSample(): SampleResponse

}
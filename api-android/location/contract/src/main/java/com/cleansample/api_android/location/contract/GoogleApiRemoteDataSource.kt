package com.cleansample.api_android.location.contract

interface LocationApiContract {
    suspend fun getLocations(latitude: Float, longitude: Float): List<String>
}
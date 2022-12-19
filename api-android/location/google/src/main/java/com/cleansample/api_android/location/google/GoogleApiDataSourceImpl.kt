package com.cleansample.api_android.location.google

import android.content.Context
import com.cleansample.api_android.location.contract.LocationApiContract
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
internal class GoogleApiDataSourceImpl @Inject constructor(@ActivityContext private val activity: Context) :
    LocationApiContract {
    override suspend fun getLocations(latitude: Float, longitude: Float): List<String> {
        return activity.resources.getStringArray(R.array.locations).map {
            it.plus(" latitude: $latitude , longitude:$longitude")
        }
    }
}
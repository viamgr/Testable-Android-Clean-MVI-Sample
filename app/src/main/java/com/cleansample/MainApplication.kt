package com.cleansample

import android.app.Application
import com.cleansample.appinitializers.AppInitializers
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Application class. Modify it if required.
 */
@HiltAndroidApp
class MainApplication : Application() {


    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }
}
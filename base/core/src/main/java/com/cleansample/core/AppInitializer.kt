package com.cleansample.core

import android.app.Application

interface AppInitializer {
    fun init(application: Application)
}
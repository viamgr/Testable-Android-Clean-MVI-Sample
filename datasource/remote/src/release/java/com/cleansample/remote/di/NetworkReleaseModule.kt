package com.cleansample.remote.di

import com.cleansample.remote.interceptor.BasicAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkReleaseModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authenticateInterceptor: BasicAuthInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authenticateInterceptor)
            .build()
    }

}
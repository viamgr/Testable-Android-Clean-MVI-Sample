package com.cleansample.remote.di

import com.cleansample.remote.api.SampleApi
import com.cleansample.remote.interceptor.BasicAuthInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    @ExperimentalSerializationApi
    internal fun provideSerializableFactory() =
        json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    internal fun provideAuthenticator(): BasicAuthInterceptor {
        return BasicAuthInterceptor("username", "password")
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: Converter.Factory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.npoint.io/")
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideAddApi(retrofit: Retrofit): SampleApi {
        return retrofit.create(SampleApi::class.java)
    }

}
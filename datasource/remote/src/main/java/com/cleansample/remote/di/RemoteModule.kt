package com.cleansample.remote.di

import com.cleansample.data.datasource.SampleRemoteDataSource
import com.cleansample.remote.datasource.SampleRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Binds
    @Singleton
    internal abstract fun bindsAddRemoteDataSource(impl: SampleRemoteDataSourceImpl): SampleRemoteDataSource
}
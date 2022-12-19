package com.cleansample.data.repository.di

import com.cleansample.data.repository.SampleRepositoryImpl
import com.cleansample.domain.repository.SampleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    internal abstract fun bindsAddRepository(impl: SampleRepositoryImpl): SampleRepository
}
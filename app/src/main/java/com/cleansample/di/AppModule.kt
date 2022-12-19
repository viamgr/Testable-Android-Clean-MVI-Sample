package com.cleansample.di

import com.cleansample.appinitializers.TimberInitializer
import com.cleansample.core.AppInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @IntoSet
    abstract fun bindsTimberInitializer(timberInitializer: TimberInitializer): AppInitializer

}

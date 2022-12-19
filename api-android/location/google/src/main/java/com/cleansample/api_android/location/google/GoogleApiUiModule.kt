package com.cleansample.api_android.location.google

import com.cleansample.api_android.location.contract.LocationApiContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class GoogleApiUiModule {

    @Binds
    @ActivityScoped
    internal abstract fun provideGoogleApiDataSource(impl: GoogleApiDataSourceImpl): LocationApiContract

}

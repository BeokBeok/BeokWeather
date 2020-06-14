package com.example.beokweather.di

import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun providesLocationManager(@ActivityContext context: Context) =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
}
package com.example.beokweather.di

import com.example.data.WeatherDataSource
import com.example.data.WeatherRepository
import com.example.data.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {

    @Provides
    fun provideWeatherRepository(weatherService: WeatherService): WeatherDataSource =
        WeatherRepository(weatherService)
}
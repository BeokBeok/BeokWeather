package com.example.beokweather.domain

import com.example.beokweather.domain.entity.WeatherResponse
import com.example.beokweather.util.Result

interface WeatherDataSource {

    suspend fun getCurrentWeather(
        lat: Double,
        lon: Double
    ): Result<WeatherResponse>
}
package com.example.beokweather.domain

import com.example.beokweather.domain.entity.WeatherResponse
import com.example.beokweather.util.Result

interface WeatherDataSource {

    suspend fun getCurrentWeather(cityName: String): Result<WeatherResponse>
}
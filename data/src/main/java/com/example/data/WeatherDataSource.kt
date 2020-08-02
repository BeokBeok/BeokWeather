package com.example.data

import com.example.common.type.Result
import com.example.data.entity.ForecastResponse
import com.example.data.entity.WeatherResponse

interface WeatherDataSource {

    suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherResponse>

    suspend fun getForecastWeather(lat: Double, lon: Double): Result<ForecastResponse>
}
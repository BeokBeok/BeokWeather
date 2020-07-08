package com.example.beokweather.domain

import com.example.beokweather.base.type.Result
import com.example.beokweather.domain.entity.ForecastResponse
import com.example.beokweather.domain.entity.WeatherResponse
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) : WeatherDataSource {

    override suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherResponse> =
        try {
            Result.Success(weatherService.getCurrentWeather(lat = lat, lon = lon, units = UNITS))
        } catch (e: Exception) {
            Result.Failure(e)
        }

    override suspend fun getForecastWeather(lat: Double, lon: Double): Result<ForecastResponse> =
        try {
            Result.Success(weatherService.getForecastWeather(lat = lat, lon = lon, units = UNITS))
        } catch (e: Exception) {
            Result.Failure(e)
        }

    companion object {
        private const val UNITS = "metric"
    }
}
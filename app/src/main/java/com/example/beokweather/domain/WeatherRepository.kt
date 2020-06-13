package com.example.beokweather.domain

import com.example.beokweather.domain.entity.WeatherResponse
import com.example.beokweather.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) : WeatherDataSource {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun getCurrentWeather(cityName: String): Result<WeatherResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(weatherService.getCurrentWeather(cityName))
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
}
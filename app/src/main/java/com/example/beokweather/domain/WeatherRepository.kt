package com.example.beokweather.domain

import com.example.beokweather.domain.entity.ForecastResponse
import com.example.beokweather.domain.entity.WeatherResponse
import com.example.beokweather.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherService: WeatherService
) : WeatherDataSource {

    private val ioDispatcher = Dispatchers.IO

    override suspend fun getCurrentWeather(lat: Double, lon: Double): Result<WeatherResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(
                    weatherService.getCurrentWeather(lat = lat, lon = lon, units = UNITS)
                )
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }

    override suspend fun getForecastWeather(lat: Double, lon: Double): Result<ForecastResponse> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(
                    weatherService.getForecastWeather(lat = lat, lon = lon, units = UNITS)
                )
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }

    companion object {
        private const val UNITS = "metric"
    }
}
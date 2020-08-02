package com.example.data

import com.example.data.entity.ForecastResponse
import com.example.data.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): WeatherResponse

    @GET("forecast")
    suspend fun getForecastWeather(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String
    ): ForecastResponse
}
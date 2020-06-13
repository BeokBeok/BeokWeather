package com.example.beokweather.domain

import com.example.beokweather.domain.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    suspend fun getCurrentWeather(@Query("q") cityName: String): WeatherResponse
}
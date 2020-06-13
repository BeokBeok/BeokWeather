package com.example.beokweather.model

data class MainModel(
    val temp: Double = 0.0,
    val tempMin: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val feelsLike: Double = 0.0,
    val tempMax: Double = 0.0
)
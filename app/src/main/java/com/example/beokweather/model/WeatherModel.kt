package com.example.beokweather.model

data class WeatherModel(
    val name: String = "",
    val main: MainModel = MainModel(),
    val icon: String = ""
)
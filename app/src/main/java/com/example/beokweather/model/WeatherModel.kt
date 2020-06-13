package com.example.beokweather.model

data class WeatherModel(
    val timezone: Int = 0,
    val main: MainModel = MainModel(),
    val iconList: List<String> = emptyList(),
    val name: String = ""
)
package com.example.beokweather.model

data class WeatherModel(
    val timezone: Int = 0,
    val main: MainModel = MainModel(),
    val weatherList: List<WeatherItemModel> = emptyList(),
    val name: String = ""
)
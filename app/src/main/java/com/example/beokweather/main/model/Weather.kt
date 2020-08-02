package com.example.beokweather.main.model

import com.example.data.entity.WeatherResponse

data class Weather(
    val name: String = "",
    val main: Main = Main(),
    val icon: String = ""
)

fun WeatherResponse.mapToModel() =
    Weather(
        name = name ?: "",
        main = mainResponse.mapToModel(),
        icon = weatherResponse?.get(0)?.icon ?: ""
    )
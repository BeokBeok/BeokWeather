package com.example.beokweather.main.model

import com.example.data.entity.ForecastResponse
import com.example.data.entity.mapToModel

data class Forecast(
    val name: String = "",
    val list: List<ListItem> = emptyList()
)

fun ForecastResponse?.mapToModel() = this?.let {
    Forecast(
        name = city.mapToModel(),
        list = list?.map { it.mapToModel() } ?: emptyList()
    )
} ?: Forecast()
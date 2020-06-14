package com.example.beokweather.main.model

import com.example.beokweather.model.ListItemModel

data class WeatherItem(
    val name: String = "",
    val icon: String = "",
    val temp: String = "",
    val tempMin: String = "",
    val tempMax: String = "",
    val detail: List<ListItemModel> = emptyList()
)
package com.example.beokweather.model

data class ForecastModel(
    val name: String = "",
    val list: List<ListItemModel> = emptyList()
)
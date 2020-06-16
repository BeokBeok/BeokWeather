package com.example.beokweather.main.model

data class Forecast(
    val name: String = "",
    val list: List<ListItem> = emptyList()
)
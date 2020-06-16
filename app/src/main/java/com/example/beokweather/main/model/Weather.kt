package com.example.beokweather.main.model

data class Weather(
    val name: String = "",
    val main: Main = Main(),
    val icon: String = ""
)
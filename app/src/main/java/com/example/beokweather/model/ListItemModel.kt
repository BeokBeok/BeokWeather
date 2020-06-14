package com.example.beokweather.model

data class ListItemModel(
    val dtTxt: String = "",
    val icon: String = "",
    val main: MainModel = MainModel()
)
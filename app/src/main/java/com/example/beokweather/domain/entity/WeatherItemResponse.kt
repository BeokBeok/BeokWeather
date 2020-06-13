package com.example.beokweather.domain.entity

import com.example.beokweather.model.WeatherItemModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherItemResponse(

    @field:Json(name = "icon")
    val icon: String? = null,

    @field:Json(name = "description")
    val description: String? = null,

    @field:Json(name = "main")
    val main: String? = null,

    @field:Json(name = "id")
    val id: Int? = null
)

fun WeatherItemResponse?.mapToModel() = this?.let {
    WeatherItemModel(
        icon = icon ?: "",
        description = description ?: "",
        main = main ?: "",
        id = id ?: 0
    )
} ?: WeatherItemModel()
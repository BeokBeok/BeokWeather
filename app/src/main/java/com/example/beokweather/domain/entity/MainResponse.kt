package com.example.beokweather.domain.entity

import com.example.beokweather.model.MainModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainResponse(

    @field:Json(name = "temp")
    val temp: Double? = null,

    @field:Json(name = "temp_min")
    val tempMin: Double? = null,

    @field:Json(name = "humidity")
    val humidity: Int? = null,

    @field:Json(name = "pressure")
    val pressure: Int? = null,

    @field:Json(name = "feels_like")
    val feelsLike: Double? = null,

    @field:Json(name = "temp_max")
    val tempMax: Double? = null
)

fun MainResponse?.mapToModel() = this?.let {
    MainModel(
        temp = temp ?: 0.0,
        tempMin = tempMin ?: 0.0,
        humidity = humidity ?: 0,
        feelsLike = feelsLike ?: 0.0,
        tempMax = tempMax ?: 0.0
    )
} ?: MainModel()
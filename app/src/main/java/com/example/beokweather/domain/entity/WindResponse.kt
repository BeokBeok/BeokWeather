package com.example.beokweather.domain.entity

import com.example.beokweather.model.WindModel
import com.squareup.moshi.Json

data class WindResponse(

    @field:Json(name = "deg")
    val deg: Int? = null,

    @field:Json(name = "speed")
    val speed: Double? = null
)

fun WindResponse?.mapToModel() = this?.let {
    WindModel(deg = deg ?: 0, speed = speed ?: 0.0)
} ?: WindModel()
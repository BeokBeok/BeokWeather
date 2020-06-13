package com.example.beokweather.domain.entity

import com.example.beokweather.model.SysModel
import com.squareup.moshi.Json

data class SysResponse(

    @field:Json(name = "country")
    val country: String? = null,

    @field:Json(name = "sunrise")
    val sunrise: Int? = null,

    @field:Json(name = "sunset")
    val sunset: Int? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "type")
    val type: Int? = null
)

fun SysResponse?.mapToModel() = this?.let {
    SysModel(
        country = country ?: "",
        sunrise = sunrise ?: 0,
        sunset = sunset ?: 0,
        id = id ?: 0,
        type = type ?: 0
    )
} ?: SysModel()
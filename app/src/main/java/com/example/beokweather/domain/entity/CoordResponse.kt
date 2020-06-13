package com.example.beokweather.domain.entity

import com.example.beokweather.model.CoordModel
import com.squareup.moshi.Json

data class CoordResponse(

    @field:Json(name = "lon")
    val lon: Double? = null,

    @field:Json(name = "lat")
    val lat: Double? = null
)

fun CoordResponse?.mapToModel() = this?.let {
    CoordModel(lon = lon ?: 0.0, lat = lat ?: 0.0)
} ?: CoordModel()
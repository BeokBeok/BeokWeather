package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class CoordResponse(

    @field:Json(name = "lon")
    val lon: Double? = null,

    @field:Json(name = "lat")
    val lat: Double? = null
)

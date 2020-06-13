package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class CoordResponse(

    @Json(name = "lon")
    val lon: Double? = null,

    @Json(name = "lat")
    val lat: Double? = null
)

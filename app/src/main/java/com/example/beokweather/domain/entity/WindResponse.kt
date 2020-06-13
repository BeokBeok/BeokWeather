package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class WindResponse(

    @Json(name = "deg")
    val deg: Int? = null,

    @Json(name = "speed")
    val speed: Double? = null
)
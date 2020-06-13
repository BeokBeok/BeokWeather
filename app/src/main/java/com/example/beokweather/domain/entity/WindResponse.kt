package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class WindResponse(

    @field:Json(name = "deg")
    val deg: Int? = null,

    @field:Json(name = "speed")
    val speed: Double? = null
)
package com.example.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindResponse(

    @field:Json(name = "deg")
    val deg: Int? = null,

    @field:Json(name = "speed")
    val speed: Double? = null
)
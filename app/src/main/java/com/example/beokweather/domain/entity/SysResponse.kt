package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class SysResponse(

    @Json(name = "country")
    val country: String? = null,

    @Json(name = "sunrise")
    val sunrise: Int? = null,

    @Json(name = "sunset")
    val sunset: Int? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "type")
    val type: Int? = null
)
package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

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
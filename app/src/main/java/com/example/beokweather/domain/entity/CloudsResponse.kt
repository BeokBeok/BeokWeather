package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class CloudsResponse(

    @field:Json(name = "all")
    val all: Int? = null
)

package com.example.beokweather.domain.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudsResponse(

    @field:Json(name = "all")
    val all: Int? = null
)
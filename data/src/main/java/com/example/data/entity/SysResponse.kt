package com.example.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SysResponse(

    @field:Json(name = "country")
    val country: String? = null,

    @field:Json(name = "sunrise")
    val sunrise: Int? = null,

    @field:Json(name = "sunset")
    val sunset: Int? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "type")
    val type: Int? = null,

    @field:Json(name = "pod")
    val pod: String? = null
)
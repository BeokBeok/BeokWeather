package com.example.beokweather.domain.entity

import com.example.beokweather.model.CloudsModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudsResponse(

    @field:Json(name = "all")
    val all: Int? = null
)

fun CloudsResponse?.mapToModel() = this?.let {
    CloudsModel(all = all ?: 0)
} ?: CloudsModel()
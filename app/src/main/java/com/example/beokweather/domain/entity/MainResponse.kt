package com.example.beokweather.domain.entity

import com.example.beokweather.model.MainModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
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
    val tempMax: Double? = null,

    @field:Json(name = "grnd_level")
    val grndLevel: Int? = null,

    @field:Json(name = "temp_kf")
    val tempKf: Double? = null,

    @field:Json(name = "sea_level")
    val seaLevel: Int? = null
)

fun MainResponse?.mapToModel() = this?.let {
    MainModel(
        temp = temp?.let {
            it.toString().substringBefore(".") + "°"
        } ?: "",
        tempMin = tempMin?.let {
            it.toString().substringBefore(".") + "°"
        } ?: "",
        tempMax = tempMax?.let {
            it.toString().substringBefore(".") + "°"
        } ?: ""
    )
} ?: MainModel()
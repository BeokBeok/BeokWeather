package com.example.beokweather.domain.entity

import com.example.beokweather.main.model.Forecast
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ForecastResponse(

    @field:Json(name = "city")
    val city: CityResponse? = null,

    @field:Json(name = "cnt")
    val cnt: Int? = null,

    @field:Json(name = "cod")
    val cod: String? = null,

    @field:Json(name = "message")
    val message: Int? = null,

    @field:Json(name = "list")
    val list: List<ListItemResponse?>? = null
)

fun ForecastResponse?.mapToModel() = this?.let {
    Forecast(
        name = city.mapToModel(),
        list = list?.map { it.mapToModel() } ?: emptyList()
    )
} ?: Forecast()

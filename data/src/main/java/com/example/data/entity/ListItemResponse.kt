package com.example.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListItemResponse(

    @field:Json(name = "dt")
    val dt: Int? = null,

    @field:Json(name = "dt_txt")
    val dtTxt: String? = null,

    @field:Json(name = "weather")
    val weather: List<WeatherItemResponse?>? = null,

    @field:Json(name = "main")
    val main: MainResponse? = null,

    @field:Json(name = "clouds")
    val clouds: CloudsResponse? = null,

    @field:Json(name = "sys")
    val sys: SysResponse? = null,

    @field:Json(name = "wind")
    val wind: WindResponse? = null
)
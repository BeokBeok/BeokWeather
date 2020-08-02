package com.example.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponse(

    @field:Json(name = "visibility")
	val visibility: Int? = null,

    @field:Json(name = "timezone")
	val timezone: Int? = null,

    @field:Json(name = "main")
	val mainResponse: MainResponse? = null,

    @field:Json(name = "clouds")
	val cloudsResponse: CloudsResponse? = null,

    @field:Json(name = "sys")
	val sysResponse: SysResponse? = null,

    @field:Json(name = "dt")
	val dt: Int? = null,

    @field:Json(name = "coord")
	val coordResponse: CoordResponse? = null,

    @field:Json(name = "weather")
	val weatherResponse: List<WeatherItemResponse?>? = null,

    @field:Json(name = "name")
	val name: String? = null,

    @field:Json(name = "cod")
	val cod: Int? = null,

    @field:Json(name = "id")
	val id: Int? = null,

    @field:Json(name = "base")
	val base: String? = null,

    @field:Json(name = "wind")
	val windResponse: WindResponse? = null
)

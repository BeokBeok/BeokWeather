package com.example.beokweather.domain.entity

import com.squareup.moshi.Json

data class WeatherResponse(

	@Json(name = "visibility")
	val visibility: Int? = null,

	@Json(name = "timezone")
	val timezone: Int? = null,

	@Json(name = "main")
	val mainResponse: MainResponse? = null,

	@Json(name = "clouds")
	val cloudsResponse: CloudsResponse? = null,

	@Json(name = "sys")
	val sysResponse: SysResponse? = null,

	@Json(name = "dt")
	val dt: Int? = null,

	@Json(name = "coord")
	val coordResponse: CoordResponse? = null,

	@Json(name = "weather")
	val weatherResponse: List<WeatherItemResponse?>? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "cod")
	val cod: Int? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "base")
	val base: String? = null,

	@Json(name = "wind")
	val windResponse: WindResponse? = null
)
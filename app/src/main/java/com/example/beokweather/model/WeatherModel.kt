package com.example.beokweather.model

data class WeatherModel(
    val visibility: Int = 0,
    val timezone: Int = 0,
    val mainResponse: MainModel = MainModel(),
    val cloudsResponse: CloudsModel = CloudsModel(),
    val sysResponse: SysModel = SysModel(),
    val dt: Int = 0,
    val coordResponse: CoordModel = CoordModel(),
    val weatherResponse: List<WeatherItemModel> = emptyList(),
    val name: String = "",
    val cod: Int = 0,
    val id: Int = 0,
    val base: String = "",
    val windResponse: WindModel = WindModel()
)
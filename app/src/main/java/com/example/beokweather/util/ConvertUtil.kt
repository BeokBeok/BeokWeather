package com.example.beokweather.util

import android.annotation.SuppressLint
import com.example.beokweather.main.model.Forecast
import com.example.beokweather.main.model.ListItem
import com.example.beokweather.main.model.WeatherItem
import java.text.SimpleDateFormat
import java.util.*

object ConvertUtil {

    @SuppressLint("SimpleDateFormat")
    private val dateFormatForYYYYMMDD = SimpleDateFormat("yyyy-MM-dd")

    fun convertToWeatherItem(weatherList: List<Forecast>): List<WeatherItem> {
        if (weatherList.isEmpty()) return emptyList()

        val now = dateFormatForYYYYMMDD.format(Date())
        val (current, forecast) = weatherList[0] to weatherList[1]
        val groupedForecastList = forecast.list.groupBy { it.dtTxt.substringBefore(" ") }

        val convertedList = mutableListOf<WeatherItem>()

        convertedList.add(
            convertToTodayWeather(current, groupedForecastList[now] ?: emptyList())
        )

        for (key in groupedForecastList.keys) {
            if (key == now) continue
            convertedList.add(
                convertToForecastWeather(key, groupedForecastList[key] ?: emptyList())
            )
        }
        return convertedList
    }

    private fun convertToTodayWeather(current: Forecast, detail: List<ListItem>) =
        WeatherItem(
            name = current.name,
            date = "Today",
            icon = current.list[0].icon,
            temp = current.list[0].main.temp,
            tempMin = current.list[0].main.tempMin,
            tempMax = current.list[0].main.tempMax,
            detail = detail
        )

    private fun convertToForecastWeather(date: String, detail: List<ListItem>) =
        WeatherItem(
            date = date,
            icon = detail[0].icon,
            temp = detail[0].main.temp,
            tempMin = detail[0].main.tempMin,
            tempMax = detail[0].main.tempMax,
            detail = detail
        )
}
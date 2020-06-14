package com.example.beokweather.util

import android.annotation.SuppressLint
import com.example.beokweather.main.model.WeatherItem
import com.example.beokweather.model.ForecastModel
import java.text.SimpleDateFormat
import java.util.*

object ConvertUtil {

    @SuppressLint("SimpleDateFormat")
    private val dateFormatForYYYYMMDD = SimpleDateFormat("yyyy-MM-dd")

    fun convertToWeatherItem(forecastList: List<ForecastModel>): List<WeatherItem> {
        val now = Date()
        val listItem = mutableListOf<WeatherItem>()
        val forecastByDate = forecastList[1].list.groupBy { it.dtTxt.substringBefore(" ") }
        listItem.add(
            WeatherItem(
                name = forecastList[0].name,
                date = dateFormatForYYYYMMDD.format(now),
                icon = forecastList[0].list[0].icon,
                temp = forecastList[0].list[0].main.temp,
                tempMin = forecastList[0].list[0].main.tempMin,
                tempMax = forecastList[0].list[0].main.tempMax,
                detail = forecastByDate[dateFormatForYYYYMMDD.format(now)] ?: emptyList()
            )
        )

        for (key in forecastByDate.keys) {
            if (key == dateFormatForYYYYMMDD.format(now)) continue
            listItem.add(
                WeatherItem(
                    name = forecastList[0].name,
                    date = key,
                    icon = forecastByDate[key]?.get(0)?.icon ?: "",
                    temp = forecastByDate[key]?.get(0)?.main?.temp ?: "",
                    tempMin = forecastByDate[key]?.get(0)?.main?.tempMin ?: "",
                    tempMax = forecastByDate[key]?.get(0)?.main?.tempMax ?: "",
                    detail = forecastByDate[key] ?: emptyList()
                )
            )
        }
        return listItem
    }
}
package com.example.beokweather.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherItem(
    val name: String = "",
    val date: String = "",
    val icon: String = "",
    val temp: String = "",
    val tempMin: String = "",
    val tempMax: String = "",
    val detail: List<ListItem> = emptyList()
) : Parcelable
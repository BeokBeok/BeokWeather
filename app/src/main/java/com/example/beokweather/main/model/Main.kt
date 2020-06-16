package com.example.beokweather.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Main(
    val temp: String = "",
    val tempMin: String = "",
    val tempMax: String = ""
) : Parcelable
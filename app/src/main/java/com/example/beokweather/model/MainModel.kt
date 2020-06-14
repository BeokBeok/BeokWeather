package com.example.beokweather.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainModel(
    val temp: String = "",
    val tempMin: String = "",
    val tempMax: String = ""
) : Parcelable
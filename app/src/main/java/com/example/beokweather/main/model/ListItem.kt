package com.example.beokweather.main.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val dtTxt: String = "",
    val icon: String = "",
    val main: Main = Main()
) : Parcelable
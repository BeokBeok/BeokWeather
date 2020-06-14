package com.example.beokweather.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItemModel(
    val dtTxt: String = "",
    val icon: String = "",
    val main: MainModel = MainModel()
) : Parcelable
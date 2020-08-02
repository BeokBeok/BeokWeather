package com.example.beokweather.main.model

import android.os.Parcelable
import com.example.data.entity.ListItemResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListItem(
    val dtTxt: String = "",
    val icon: String = "",
    val main: Main = Main()
) : Parcelable

fun ListItemResponse?.mapToModel() = this?.let {
    ListItem(
        dtTxt = dtTxt ?: "",
        icon = weather?.get(0)?.icon ?: "",
        main = main.mapToModel()
    )
} ?: ListItem()
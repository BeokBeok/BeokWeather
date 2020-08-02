package com.example.beokweather.main.model

import android.os.Parcelable
import com.example.data.entity.MainResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Main(
    val temp: String = "",
    val tempMin: String = "",
    val tempMax: String = ""
) : Parcelable

fun MainResponse?.mapToModel() = this?.let {
    Main(
        temp = temp?.let {
            it.toString().substringBefore(".") + "°"
        } ?: "",
        tempMin = tempMin?.let {
            it.toString().substringBefore(".") + "°"
        } ?: "",
        tempMax = tempMax?.let {
            it.toString().substringBefore(".") + "°"
        } ?: ""
    )
} ?: Main()
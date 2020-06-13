package com.example.beokweather.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:setWeatherIcon")
fun ImageView.setWeatherIcon(iconName: String?) {
    if (iconName.isNullOrEmpty()) return

    val convertPath = iconName.replace(iconName, "ic_weather_$iconName")
    val imageId = context.resources.getIdentifier(convertPath, "drawable", context.packageName)
    setImageDrawable(context.resources.getDrawable(imageId, null))
}
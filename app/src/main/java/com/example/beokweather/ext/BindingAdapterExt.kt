package com.example.beokweather.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.beokweather.base.BaseAdapter

@BindingAdapter("bind:setWeatherIcon")
fun setWeatherIcon(imageView: ImageView, iconName: String?) {
    if (iconName.isNullOrEmpty()) return

    imageView.run {
        val convertPath = iconName.replace(iconName, "ic_weather_$iconName")
        val imageId = context.resources.getIdentifier(convertPath, "drawable", context.packageName)
        setImageDrawable(context.resources.getDrawable(imageId, null))
    }
}

@BindingAdapter("bind:replaceItems")
fun replaceItems(recyclerView: RecyclerView, item: List<Any>?) {
    if (item == null) return

    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as BaseAdapter<Any>).run {
        replaceItems(item)
        notifyDataSetChanged()
    }
}
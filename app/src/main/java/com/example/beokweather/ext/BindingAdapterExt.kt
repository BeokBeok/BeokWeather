package com.example.beokweather.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beokweather.base.BaseAdapter

@BindingAdapter("bind:setWeatherIcon")
fun setWeatherIcon(imageView: ImageView, iconName: String?) {
    if (iconName.isNullOrEmpty()) return

    val iconUrl = "http://openweathermap.org/img/wn/$iconName@4x.png"
    Glide.with(imageView)
        .load(iconUrl)
        .error(android.R.drawable.ic_menu_help)
        .into(imageView)
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
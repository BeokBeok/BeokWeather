package com.example.beokweather.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.beokweather.base.BaseAdapter

@BindingAdapter("bind:replaceItems")
fun RecyclerView.replaceItems(item: List<Any>?) {
    if (item == null) return
    @Suppress("UNCHECKED_CAST")
    (adapter as? BaseAdapter<Any>)?.run {
        replaceItems(item)
        notifyDataSetChanged()
    }
}
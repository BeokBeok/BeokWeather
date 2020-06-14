package com.example.beokweather.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.collection.ArrayMap
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(
    parent: ViewGroup,
    private val layoutBindingId: Pair<Int, Int>,
    private val viewModels: ArrayMap<Int, BaseViewModel>
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(layoutBindingId.first, parent, false)
) {
    private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    open fun bindViewHolder(item: Any?) {
        for (key in viewModels.keys) {
            binding.setVariable(key, viewModels[key])
        }
        if (item == null) return
        binding.setVariable(layoutBindingId.second, item)
    }
}
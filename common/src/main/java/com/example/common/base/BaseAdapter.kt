package com.example.common.base

import android.util.ArrayMap
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<ITEM : Any>(
    private val layoutBindingId: Pair<Int, Int>,
    private val viewModels: ArrayMap<Int, ViewModel>? = null
) : RecyclerView.Adapter<BaseViewHolder>() {

    private val itemList = mutableListOf<ITEM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            parent,
            layoutBindingId,
            viewModels
        )

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindViewHolder(itemList[position])
    }

    fun replaceItems(items: List<ITEM>?) {
        if (items == null) return

        itemList.run {
            clear()
            addAll(items)
        }
    }
}
package com.example.beokweather.base

import android.view.ViewGroup
import androidx.collection.ArrayMap
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<ITEM : Any>(
    private val layoutBindingId: Pair<Int, Int>,
    private val viewModels: ArrayMap<Int, BaseViewModel>? = null
) : RecyclerView.Adapter<BaseViewHolder>() {

    private val itemList = mutableListOf<ITEM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(parent, layoutBindingId, viewModels)

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
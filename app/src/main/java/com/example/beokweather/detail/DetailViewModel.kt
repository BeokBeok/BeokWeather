package com.example.beokweather.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.beokweather.main.model.WeatherItem

class DetailViewModel @ViewModelInject constructor() : ViewModel() {

    private val _weatherItem = MutableLiveData<WeatherItem>()
    val weatherItem: LiveData<WeatherItem> get() = _weatherItem

    fun setupItem(item: WeatherItem) {
        _weatherItem.value = item
    }
}
package com.example.beokweather.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.beokweather.base.BaseViewModel
import com.example.beokweather.base.type.Result
import com.example.beokweather.domain.WeatherRepository
import com.example.beokweather.domain.entity.mapToModel
import com.example.beokweather.main.model.Forecast
import com.example.beokweather.main.model.ListItem
import com.example.beokweather.main.model.WeatherItem
import com.example.beokweather.util.ConvertUtil
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : BaseViewModel() {

    private val _weathers = MutableLiveData<List<WeatherItem>>()
    val weathers: LiveData<List<WeatherItem>> get() = _weathers

    private val _errMsg = MutableLiveData<String>()
    val errMsg: LiveData<String> get() = _errMsg

    private val _selectedItem = MutableLiveData<WeatherItem>()
    val selectedItem: LiveData<WeatherItem> get() = _selectedItem

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val weatherList = mutableListOf<Forecast>()

    override fun onClick(item: Any?) {
        if (item is WeatherItem) {
            _selectedItem.value = item
        }
    }

    fun getWeather(lat: Double, lon: Double) = viewModelScope.launch {
        showLoading()
        val currentWeather = async { weatherRepository.getCurrentWeather(lat, lon) }
        val forecastWeather = async { weatherRepository.getForecastWeather(lat, lon) }

        when (val current = currentWeather.await()) {
            is Result.Success -> {
                current.data.mapToModel().run {
                    weatherList.add(
                        Forecast(
                            name = name,
                            list = listOf(ListItem(dtTxt = "Today", icon = icon, main = main))
                        )
                    )
                }
            }
            is Result.Failure -> {
                hideLoading()
                _errMsg.value = current.exception.message ?: ""
                _weathers.value = emptyList()
                return@launch
            }
        }

        when (val forecast = forecastWeather.await()) {
            is Result.Success -> {
                weatherList.add(forecast.data.mapToModel())
            }
            is Result.Failure -> {
                hideLoading()
                _errMsg.value = forecast.exception.message ?: ""
                _weathers.value = emptyList()
                return@launch
            }
        }

        setupWeatherItem()
        hideLoading()
    }

    private fun setupWeatherItem() {
        _weathers.value = ConvertUtil.convertToWeatherItem(weatherList)
    }

    private fun hideLoading() {
        _isLoading.value = false
    }

    private fun showLoading() {
        _isLoading.value = true
    }
}
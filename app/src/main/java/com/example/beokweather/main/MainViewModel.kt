package com.example.beokweather.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.beokweather.base.BaseViewModel
import com.example.beokweather.base.type.Result
import com.example.beokweather.base.type.SingleEvent
import com.example.beokweather.base.type.isSuccess
import com.example.beokweather.domain.WeatherRepository
import com.example.beokweather.domain.entity.mapToModel
import com.example.beokweather.main.model.WeatherItem
import com.example.beokweather.main.model.Forecast
import com.example.beokweather.main.model.ListItem
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

    private val _selectedItem = MutableLiveData<SingleEvent<WeatherItem>>()
    val selectedItem: LiveData<SingleEvent<WeatherItem>> get() = _selectedItem

    private val weatherList = mutableListOf<Forecast>()

    override fun onClick(item: Any?) {
        if (item is WeatherItem) {
            _selectedItem.value =
                SingleEvent(item)
        }
    }

    fun getWeather(lat: Double, lon: Double) = viewModelScope.launch {
        val currentWeather = async { weatherRepository.getCurrentWeather(lat, lon) }
        val forecastWeather = async { weatherRepository.getForecastWeather(lat, lon) }

        currentWeather.await().let {
            if (it.isSuccess) {
                (it as Result.Success).data.mapToModel().run {
                    weatherList.add(
                        Forecast(
                            name = name,
                            list = listOf(
                                ListItem(
                                    dtTxt = "Today",
                                    icon = icon,
                                    main = main
                                )
                            )
                        )
                    )
                }
            } else {
                _errMsg.value = (it as Result.Failure).exception.message
            }
        }

        forecastWeather.await().let {
            if (it.isSuccess) {
                weatherList.add((it as Result.Success).data.mapToModel())
            } else {
                _errMsg.value = (it as Result.Failure).exception.message
            }
        }

        _weathers.value = ConvertUtil.convertToWeatherItem(weatherList)
    }
}
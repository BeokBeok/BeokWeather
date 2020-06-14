package com.example.beokweather.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.beokweather.base.BaseViewModel
import com.example.beokweather.domain.WeatherRepository
import com.example.beokweather.domain.entity.mapToModel
import com.example.beokweather.main.model.WeatherItem
import com.example.beokweather.model.ForecastModel
import com.example.beokweather.model.ListItemModel
import com.example.beokweather.util.ConvertUtil
import com.example.beokweather.util.Result
import com.example.beokweather.util.isSuccess
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : BaseViewModel() {

    private val _weathers = MutableLiveData<List<WeatherItem>>()
    val weathers: LiveData<List<WeatherItem>> get() = _weathers

    private val _errMsg = MutableLiveData<String>()
    val errMsg: LiveData<String> get() = _errMsg

    private val weatherList = mutableListOf<ForecastModel>()

    fun getWeather(lat: Double, lon: Double) = viewModelScope.launch {
        weatherRepository.getCurrentWeather(lat, lon).let {
            if (it.isSuccess) {
                (it as Result.Success).data.mapToModel().run {
                    weatherList.add(
                        ForecastModel(
                            name = name,
                            list = listOf(ListItemModel(dtTxt = "Today", icon = icon, main = main))
                        )
                    )
                }
            } else {
                _errMsg.value = (it as Result.Failure).exception.message
            }
        }

        weatherRepository.getForecastWeather(lat, lon).let {
            if (it.isSuccess) {
                weatherList.add((it as Result.Success).data.mapToModel())
            } else {
                _errMsg.value = (it as Result.Failure).exception.message
            }
        }

        _weathers.value = ConvertUtil.convertToWeatherItem(weatherList)
    }
}
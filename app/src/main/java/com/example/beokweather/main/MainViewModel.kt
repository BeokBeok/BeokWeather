package com.example.beokweather.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beokweather.domain.WeatherRepository
import com.example.beokweather.domain.entity.mapToModel
import com.example.beokweather.model.WeatherModel
import com.example.beokweather.util.Result
import com.example.beokweather.util.isSuccess
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherResponse = MutableLiveData<WeatherModel>()
    val weatherResponse: LiveData<WeatherModel> get() = _weatherResponse

    private val _errMsg = MutableLiveData<String>()
    val errMsg: LiveData<String> get() = _errMsg

    fun getCurrentWeather(lat: Double, lon: Double) = viewModelScope.launch {
        val result = weatherRepository.getCurrentWeather(lat, lon)
        if (result.isSuccess) {
            _weatherResponse.value = ((result as Result.Success).data).mapToModel()
        } else {
            _errMsg.value = (result as Result.Failure).exception.message
        }
    }
}
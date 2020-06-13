package com.example.beokweather

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beokweather.domain.WeatherRepository
import com.example.beokweather.domain.entity.WeatherResponse
import com.example.beokweather.util.Result
import com.example.beokweather.util.isSuccess
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherResponse = MutableLiveData<WeatherResponse>()
    val weatherResponse: LiveData<WeatherResponse> get() = _weatherResponse

    private val _errMsg = MutableLiveData<String>()
    val errMsg: LiveData<String> get() = _errMsg

    fun getCurrentWeather(cityName: String) = viewModelScope.launch {
        val result = weatherRepository.getCurrentWeather(cityName)
        if (result.isSuccess) {
            _weatherResponse.value = (result as Result.Success).data
        } else {
            _errMsg.value = (result as Result.Failure).exception.message
        }
    }
}
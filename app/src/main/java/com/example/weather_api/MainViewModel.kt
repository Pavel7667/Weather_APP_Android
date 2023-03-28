package com.example.weather_api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_api.adapters.WeatherModel

/**
 * Main view model for holding INFO
 *
 * @constructor Create empty Main view model
 */
class MainViewModel : ViewModel() {

    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()

}
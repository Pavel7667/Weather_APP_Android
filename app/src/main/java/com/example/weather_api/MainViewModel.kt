package com.example.weather_api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Main view model for holding INFO
 *
 * @constructor Create empty Main view model
 */
class MainViewModel : ViewModel() {

    val liveDataCurrent = MutableLiveData<String>()
    val liveDataList = MutableLiveData<String>()

}
package com.example.weather_api.adapters


import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_api.databinding.ListItemBinding

class WeatherAdapter : ListAdapter<WeatherModel,WeatherAdapter.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ListItemBinding.bind(view)
        fun bind(item: WeatherModel) = with(binding) {
            tvTime.text = item.time
            tvSun.text = item.condition
            tvTemp.text = item.currentTemp
        }
    }
}
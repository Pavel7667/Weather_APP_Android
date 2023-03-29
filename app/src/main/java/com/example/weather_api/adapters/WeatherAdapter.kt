package com.example.weather_api.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_api.R
import com.example.weather_api.databinding.ListItemBinding
import com.squareup.picasso.Picasso

/**
 * WeatherAdapter create View from ViewModel
 */
class WeatherAdapter(val listener: Listener?) :
    ListAdapter<WeatherModel, WeatherAdapter.Holder>(Comparator()) {

    /**
     * Holder push to View INFO from Model
     */
    class Holder(view: View, val listener: Listener?) : RecyclerView.ViewHolder(view) {
        val binding = ListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null

        init {
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun bind(item: WeatherModel) = with(binding) {
            itemTemp = item
            tvTime.text = item.time
            tvSun.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}/${item.minTemp}°C" }
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }

    /**
     * Comparator check are Elements is Same
     */
    class Comparator : DiffUtil.ItemCallback<WeatherModel>() {
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }

    // WeatherAdapter methods //

    /**
     * onCreateViewHolder push to View INFO from Model
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view,listener)
    }

    /**
     * onBindViewHolder push to View INFO from Model
     */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onClick(item: WeatherModel)
    }
}
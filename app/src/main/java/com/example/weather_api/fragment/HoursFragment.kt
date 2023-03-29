package com.example.weather_api.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather_api.adapters.WeatherAdapter
import com.example.weather_api.adapters.WeatherModel
import com.example.weather_api.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var  adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Push elements to Hours Fragment
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }
    /**
     * Push elements from LIST to Hours Fragment
     */
    private fun initRcView()=with(binding){
        rcView.layoutManager =LinearLayoutManager(activity)
        adapter=WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("dnepr","10:00","Sunny","25",
                "","","",""),
            WeatherModel("dnepr","12:00","Sunny","20",
                "","","",""),
            WeatherModel("dnepr","14:00","Cloudy","18",
                "","","",""),
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }
}
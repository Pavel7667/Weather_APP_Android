package com.example.weather_api.fragment

import android.Manifest
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weather_api.adapters.VpAdapter
import com.example.weather_api.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

const val API_KEY = "8af04a7d0ff243f59f882715232803"


/**
 * Fragment for work
 *
 * @constructor Create empty Main fragment
 */
class MainFragment : Fragment() {
    // List of Fragments
    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )

    // List of TabLayout Names
    private val tList = listOf(
        "HOURS_XXX",
        "DAYS"
    )
    private lateinit var binding: FragmentMainBinding
    private lateinit var pLauncher: ActivityResultLauncher<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * On popApp for access Location of phone
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
        requestWeatherData("Dnipropetrovsk")
    }

    /**
     * Fun Init to switching between Fragments
     */
    private fun init() = with(binding) {
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp) { tab, pos ->
            tab.text = tList[pos]
        }.attach()
    }

    /**
     * On popApp for access Location of phone
     */
    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { Toast.makeText(activity, "Persmisson is $it", Toast.LENGTH_LONG).show() }
    }

    /**
     * On popApp for access Location of phone
     */
    private fun checkPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun requestWeatherData(city: String) {
        val url = "https://api.weatherapi.com/v1/forecast.json?" +
                "key=$API_KEY" +
                "&q=$city" +
                "&days=3" +
                "&aqi=no" +
                "&alerts=no"

        val queue = Volley.newRequestQueue(context)
        val request = StringRequest(
            Request.Method.GET,
            url,
            { result ->
                Log.d("MyLog", "Result == $result")
            },
            { error ->
                Log.d("MyLog", "Show error: $error")
            }
        )
        queue.add(request)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
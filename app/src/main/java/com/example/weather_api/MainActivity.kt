package com.example.weather_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather_api.fragment.MainFragment

/**
 * App will be having only ONE main activity - with many fragments on MainFragment
 *
 * @constructor Create empty Main activity
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // push MainFragment to View
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.placeHolder,MainFragment.newInstance())
            .commit()
    }
}
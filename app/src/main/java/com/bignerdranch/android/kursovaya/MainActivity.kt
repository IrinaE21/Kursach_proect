package com.bignerdranch.android.kursovaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bignerdranch.android.kursovaya.databinding.ActivityMainBinding

const val API_KEY = "c226fc1e5e3344bea1e174450230906"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("London")

        }
    }
    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
            "?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                    response->
                        Log.d("MyLog", "Response: $response")
            },
            {
                Log.d("MyLog", "Volley error: $it")
            }
            )
        queue.add(stringRequest)
    }
}
package com.koducation.androidcourse101.ui.radios

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.data.RadioServiceProvider
import com.koducation.androidcourse101.data.model.Radio
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RadiosFragment : Fragment() {

    private val radioServiceProvider = RadioServiceProvider()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loadPopularRadios()
        loadLocationRadios()
    }

    private fun loadPopularRadios() {
        radioServiceProvider.radioService.popularRadios().enqueue(object : Callback<List<Radio>> {

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Popular Radios: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }
        })
    }

    private fun loadLocationRadios() {

        radioServiceProvider.radioService.locationRadios().enqueue(object : Callback<List<Radio>> {

            override fun onResponse(call: Call<List<Radio>>, response: Response<List<Radio>>) {
                Log.v("TEST", "Location Radios: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Radio>>, t: Throwable) {
                Log.v("TEST", "${t.message}")
            }
        })
    }
}
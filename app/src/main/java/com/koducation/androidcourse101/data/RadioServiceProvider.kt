package com.koducation.androidcourse101.data

import com.koducation.androidcourse101.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RadioServiceProvider {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .build()

    val radioService = retrofit.create<RadioService>(RadioService::class.java)

}
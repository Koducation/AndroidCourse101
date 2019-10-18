package com.koducation.androidcourse101.ui.radios

import android.view.View
import com.koducation.androidcourse101.data.Resource
import com.koducation.androidcourse101.data.Status.*
import com.koducation.androidcourse101.data.remote.model.Radio

data class RadiosFragmentViewState(
    private val popularRadioResource: Resource<List<Radio>>,
    private val locationRadioResource: Resource<List<Radio>>
) {

    fun getPopularRadios() = popularRadioResource.data ?: arrayListOf()

    fun getLocationRadios() = locationRadioResource.data ?: arrayListOf()

    fun getPopularRadiosLoadingVisibility(): Int {
        return when (popularRadioResource.status) {
            LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }

    fun getLocationRadiosLoadingVisibility(): Int {
        return when (locationRadioResource.status) {
            LOADING -> View.VISIBLE
            else -> View.GONE
        }
    }

    fun getPopularRadiosReloadButtonVisibility(): Int{
        return when (popularRadioResource.status) {
            ERROR -> View.VISIBLE
            else -> View.GONE
        }
    }

    fun getLocationRadiosReloadButtonVisibility(): Int{
        return when (locationRadioResource.status) {
            ERROR -> View.VISIBLE
            else -> View.GONE
        }
    }

}
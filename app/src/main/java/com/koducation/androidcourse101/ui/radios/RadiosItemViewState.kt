package com.koducation.androidcourse101.ui.radios

import com.koducation.androidcourse101.data.remote.model.Radio

data class RadiosItemViewState(val radio: Radio) {

    fun getRadioName(): String {
        return radio.radioName ?: ""
    }

    fun getRadioBand(): String {
        return radio.band ?: ""
    }

    fun getRadioImageUrl(): String {
        return radio.logo_small ?: ""
    }
}
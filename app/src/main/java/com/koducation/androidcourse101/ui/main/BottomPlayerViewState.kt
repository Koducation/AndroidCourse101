package com.koducation.androidcourse101.ui.main

import android.content.Context
import androidx.core.content.ContextCompat
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.data.remote.model.Radio

data class BottomPlayerViewState(val radio: Radio, val isFavorited: Boolean) {

    fun getFavoriteColor(context: Context): Int {
        return if (isFavorited) {
            ContextCompat.getColor(context, R.color.colorFavoriteEnabled)
        } else {
            ContextCompat.getColor(context, R.color.colorFavoriteDisabled)
        }
    }

}
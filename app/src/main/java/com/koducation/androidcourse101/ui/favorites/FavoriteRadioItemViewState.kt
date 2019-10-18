package com.koducation.androidcourse101.ui.favorites

import com.koducation.androidcourse101.data.local.entity.FavoriteRadioEntity

data class FavoriteRadioItemViewState(private val favoriteRadioEntity: FavoriteRadioEntity) {

    fun getRadioName(): String {
        return favoriteRadioEntity.radioName ?: ""
    }

    fun getRadioBand(): String {
        return favoriteRadioEntity.band ?: ""
    }
}
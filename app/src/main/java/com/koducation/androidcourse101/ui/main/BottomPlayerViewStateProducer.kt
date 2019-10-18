package com.koducation.androidcourse101.ui.main

import com.koducation.androidcourse101.data.local.entity.FavoriteRadioEntity
import com.koducation.androidcourse101.data.remote.model.Radio
import io.reactivex.functions.BiFunction

class BottomPlayerViewStateProducer :
    BiFunction<Radio, List<FavoriteRadioEntity>, BottomPlayerViewState> {

    override fun apply(
        selectedRadio: Radio,
        favoriteList: List<FavoriteRadioEntity>
    ): BottomPlayerViewState {

        favoriteList.forEach {
            if (it.id == selectedRadio.id) {
                return BottomPlayerViewState(selectedRadio, true)
            }
        }

        return BottomPlayerViewState(selectedRadio, false)
    }

}
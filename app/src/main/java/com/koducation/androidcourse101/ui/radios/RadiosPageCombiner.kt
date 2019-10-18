package com.koducation.androidcourse101.ui.radios

import com.koducation.androidcourse101.data.Resource
import com.koducation.androidcourse101.data.remote.model.Radio
import io.reactivex.functions.BiFunction

class RadiosPageCombiner :
    BiFunction<Resource<List<Radio>>, Resource<List<Radio>>, RadiosFragmentViewState> {

    override fun apply(
        popularRadios: Resource<List<Radio>>,
        locationRadios: Resource<List<Radio>>
    ): RadiosFragmentViewState {
        return RadiosFragmentViewState(popularRadios, locationRadios)
    }

}
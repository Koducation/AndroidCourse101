package com.koducation.androidcourse101.ui.radios

import com.koducation.androidcourse101.data.Resource
import com.koducation.androidcourse101.data.model.Radio

data class RadiosFragmentViewState(
    val popularRadioResource: Resource<List<Radio>>,
    val locationRadioResource: Resource<List<Radio>>
)
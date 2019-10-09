package com.koducation.androidcourse101.ui.radios

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.data.RadioDataSource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RadiosFragment : Fragment() {

    private val radioDataSource = RadioDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radios, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadRadiosPage()
    }

    @SuppressLint("CheckResult")
    private fun loadRadiosPage() {
        Observable
            .combineLatest(
                radioDataSource.fetchPopularRadios(),
                radioDataSource.fetchLocationRadios(),
                RadiosPageCombiner()
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.v(
                    "TEST",
                    "Popular Status -> ${it.popularRadioResource.status} : Location Status -> ${it.locationRadioResource.status}"
                )
            }
    }
}
package com.koducation.androidcourse101.ui.radios

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.data.RadioDataSource
import com.koducation.androidcourse101.data.Status.*
import com.koducation.androidcourse101.databinding.FragmentRadiosBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class RadiosFragment : Fragment() {

    private val radioDataSource = RadioDataSource()

    private val popularRadiosAdapter = RadiosAdapter()

    private val locationRadiosAdapter = RadiosAdapter()

    private lateinit var binding: FragmentRadiosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radios, container, false)

        binding.recyclerViewPopularRadios.adapter = popularRadiosAdapter
        binding.recyclerViewLocationRadios.adapter = locationRadiosAdapter

        return binding.root
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

                when (it.popularRadioResource.status) {
                    SUCCESS -> {
                        popularRadiosAdapter.setRadioList(it.popularRadioResource.data!!)
                        binding.progressBarPopularRadios.visibility = View.GONE
                    }
                    LOADING -> {
                        binding.progressBarPopularRadios.visibility = View.VISIBLE
                    }
                }

                when (it.locationRadioResource.status) {
                    SUCCESS -> {
                        locationRadiosAdapter.setRadioList(it.locationRadioResource.data!!)
                        binding.progressBarLocationRadios.visibility = View.GONE
                    }
                    LOADING -> {
                        binding.progressBarLocationRadios.visibility = View.VISIBLE
                    }
                }
            }
    }
}
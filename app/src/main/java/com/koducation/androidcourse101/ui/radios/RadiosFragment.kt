package com.koducation.androidcourse101.ui.radios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.FragmentRadiosBinding
import com.koducation.androidcourse101.ui.main.MainActivityViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import javax.inject.Named

class RadiosFragment : DaggerFragment() {

    @Named("popularAdapter")
    @Inject
    lateinit var popularRadiosAdapter: RadiosAdapter

    @Named("locationAdapter")
    @Inject
    lateinit var locationRadiosAdapter: RadiosAdapter

    private lateinit var binding: FragmentRadiosBinding

    private lateinit var viewModel: RadiosFragmentViewModel

    private lateinit var sharedViewModel: MainActivityViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(RadiosFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_radios, container, false)

        binding.recyclerViewPopularRadios.adapter = popularRadiosAdapter
        binding.recyclerViewLocationRadios.adapter = locationRadiosAdapter

        binding.buttonReloadLocationRadios.setOnClickListener { viewModel.loadRadiosPage() }
        binding.buttonReloadPopularRadios.setOnClickListener { viewModel.loadRadiosPage() }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sharedViewModel = ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java)

        viewModel.getRadiosLiveData().observe(this, Observer {
            popularRadiosAdapter.setRadioList(it.getPopularRadios())
            locationRadiosAdapter.setRadioList(it.getLocationRadios())

            binding.viewState = it
            binding.executePendingBindings()
        })

        popularRadiosAdapter.radioItemClicked = {
            sharedViewModel.setCurrentPlayingRadio(it)
        }

        locationRadiosAdapter.radioItemClicked = {
            sharedViewModel.setCurrentPlayingRadio(it)
        }
    }
}
package com.koducation.androidcourse101.ui.radios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.FragmentRadiosBinding
import com.koducation.androidcourse101.ui.main.MainActivityViewModel

class RadiosFragment : Fragment() {

    private val popularRadiosAdapter = RadiosAdapter()

    private val locationRadiosAdapter = RadiosAdapter()

    private lateinit var binding: FragmentRadiosBinding

    private lateinit var viewModel: RadiosFragmentViewModel

    private lateinit var sharedViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RadiosFragmentViewModel::class.java)
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
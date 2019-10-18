package com.koducation.androidcourse101.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.FragmentFavoritesBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding

    private val favoriteRadiosAdapter = FavoriteRadiosAdapter()

    private lateinit var viewModel: FavoriteFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoriteFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)
        binding.recyclerViewFavorites.adapter = favoriteRadiosAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getFavoriteRadiosLiveData().observe(this, Observer {
            favoriteRadiosAdapter.updateFavoriteList(it)
        })
    }
}
package com.koducation.androidcourse101.ui.main

import android.net.Uri
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.ActivityMainBinding
import com.koducation.androidcourse101.player.PlayerViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainActivityViewModel

    private lateinit var playerViewModel: PlayerViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewPager.adapter = MainPagerAdapter(
            context = this,
            fm = supportFragmentManager,
            behavior = FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.layoutBottomPlayer.imageViewFavorite.setOnClickListener {
            if (mainViewModel.isFavorited()) {
                mainViewModel.removeFromFavorite()
            } else {
                mainViewModel.addToFavorite()
            }
        }

        binding.layoutBottomPlayer.imageViewPlayPause.setOnClickListener {
            if (playerViewModel.isPlaying()) {
                playerViewModel.stop()
            } else {
                playerViewModel.resume()
            }
        }

        mainViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        playerViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel::class.java)

        mainViewModel.getBottomPlayerViewStateLiveData().observe(this, Observer {
            playerViewModel.start(Uri.parse(it.radio.streams?.find { it.url != null }?.url))
            binding.viewState = it
            binding.executePendingBindings()
        })

        playerViewModel.getPlayerViewStateLiveData().observe(this, Observer {
            binding.playerViewState = it
            binding.executePendingBindings()
        })
    }
}

package com.koducation.androidcourse101.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentStatePagerAdapter
import com.koducation.androidcourse101.R
import com.koducation.androidcourse101.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewPager.adapter = MainPagerAdapter(
            context = this,
            fm = supportFragmentManager,
            behavior = FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}

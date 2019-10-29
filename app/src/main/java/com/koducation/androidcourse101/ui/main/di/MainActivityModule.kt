package com.koducation.androidcourse101.ui.main.di

import com.koducation.androidcourse101.ui.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideActivityName(mainActivity: MainActivity): String {
        return mainActivity.javaClass.name
    }
}
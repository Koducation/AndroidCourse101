package com.koducation.androidcourse101.di

import com.koducation.androidcourse101.ui.main.MainActivity
import com.koducation.androidcourse101.ui.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity
}
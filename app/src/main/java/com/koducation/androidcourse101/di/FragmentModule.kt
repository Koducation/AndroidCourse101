package com.koducation.androidcourse101.di

import com.koducation.androidcourse101.ui.favorites.FavoriteFragment
import com.koducation.androidcourse101.ui.favorites.di.FavoriteFragmentModule
import com.koducation.androidcourse101.ui.radios.RadiosFragment
import com.koducation.androidcourse101.ui.radios.di.RadiosFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [FavoriteFragmentModule::class])
    abstract fun provideFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector(modules = [RadiosFragmentModule::class])
    abstract fun provideRadiosFragment(): RadiosFragment

}
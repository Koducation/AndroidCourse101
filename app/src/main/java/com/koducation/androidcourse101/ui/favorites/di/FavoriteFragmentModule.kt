package com.koducation.androidcourse101.ui.favorites.di

import com.koducation.androidcourse101.ui.favorites.FavoriteFragment
import dagger.Module
import dagger.Provides

@Module
class FavoriteFragmentModule {

    @Provides
    fun provideFragmentName(favoriteFragment: FavoriteFragment): String {
        return favoriteFragment.javaClass.name
    }
}
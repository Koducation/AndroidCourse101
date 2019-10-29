package com.koducation.androidcourse101.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.koducation.androidcourse101.ui.favorites.FavoriteFragmentViewModel
import com.koducation.androidcourse101.ui.main.MainActivityViewModel
import com.koducation.androidcourse101.ui.radios.RadiosFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RadiosFragmentViewModel::class)
    internal abstract fun bindRadiosFragmentViewModel(viewModel: RadiosFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteFragmentViewModel::class)
    internal abstract fun bindFavoriteFragmentViewModel(viewModel: FavoriteFragmentViewModel): ViewModel


}
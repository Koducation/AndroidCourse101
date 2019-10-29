package com.koducation.androidcourse101.ui.radios.di

import com.koducation.androidcourse101.ui.radios.RadiosAdapter
import com.koducation.androidcourse101.ui.radios.RadiosFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RadiosFragmentModule {

    @Provides
    @Named("locationAdapter")
    fun provideLocationAdapter(): RadiosAdapter {
        return RadiosAdapter()
    }

    @Provides
    @Named("popularAdapter")
    fun providePopularAdapter(): RadiosAdapter {
        return RadiosAdapter()
    }
}
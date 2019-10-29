package com.koducation.androidcourse101.di

import android.app.Application
import android.content.Context
import com.koducation.androidcourse101.SpotifyRadioApp
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideAppC(app: SpotifyRadioApp): Application {
        return app
    }

    @Provides
    fun provideAppContext(app: SpotifyRadioApp): Context {
        return app
    }

}
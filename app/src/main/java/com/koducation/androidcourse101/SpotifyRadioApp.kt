package com.koducation.androidcourse101

import com.koducation.androidcourse101.data.local.DatabaseProvider
import com.koducation.androidcourse101.data.local.FavoriteDataSource
import com.koducation.androidcourse101.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SpotifyRadioApp : DaggerApplication() {

    private lateinit var databaseProvider: DatabaseProvider

    private lateinit var favoriteDataSource: FavoriteDataSource

    override fun onCreate() {
        super.onCreate()
        databaseProvider = DatabaseProvider(this)
        favoriteDataSource = FavoriteDataSource(databaseProvider.getFavoriteRadiosDao())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    fun getFavoriteDataSource(): FavoriteDataSource {
        return favoriteDataSource
    }
}
package com.koducation.androidcourse101

import android.app.Application
import com.koducation.androidcourse101.data.local.DatabaseProvider
import com.koducation.androidcourse101.data.local.FavoriteDataSource

class SpotifyRadioApp : Application() {

    private lateinit var databaseProvider: DatabaseProvider

    private lateinit var favoriteDataSource: FavoriteDataSource

    override fun onCreate() {
        super.onCreate()
        databaseProvider = DatabaseProvider(this)
        favoriteDataSource = FavoriteDataSource(databaseProvider.getFavoriteRadiosDao())
    }

    fun getFavoriteDataSource(): FavoriteDataSource {
        return favoriteDataSource
    }
}
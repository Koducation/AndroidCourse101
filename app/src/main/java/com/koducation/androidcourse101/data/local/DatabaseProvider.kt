package com.koducation.androidcourse101.data.local

import android.app.Application
import androidx.room.Room

class DatabaseProvider(application: Application) {

    private val database =
        Room.databaseBuilder(application, SpotifyRadioDatabase::class.java, "spotify-database")
            .build()

    fun getFavoriteRadiosDao(): FavoriteRadioDao {
        return database.getFavoriteRadiosDao()
    }
}
package com.koducation.androidcourse101.di

import android.content.Context
import androidx.room.Room
import com.koducation.androidcourse101.data.local.FavoriteRadioDao
import com.koducation.androidcourse101.data.local.SpotifyRadioDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): SpotifyRadioDatabase {
        return Room.databaseBuilder(context, SpotifyRadioDatabase::class.java, "spotify-database")
            .build()
    }

    @Provides
    fun provideFavoriteDao(database: SpotifyRadioDatabase): FavoriteRadioDao {
        return database.getFavoriteRadiosDao()
    }
}
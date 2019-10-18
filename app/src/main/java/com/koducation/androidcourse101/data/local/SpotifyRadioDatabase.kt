package com.koducation.androidcourse101.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.koducation.androidcourse101.data.local.entity.FavoriteRadioEntity

@Database(entities = [FavoriteRadioEntity::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class SpotifyRadioDatabase : RoomDatabase() {
    abstract fun getFavoriteRadiosDao(): FavoriteRadioDao
}
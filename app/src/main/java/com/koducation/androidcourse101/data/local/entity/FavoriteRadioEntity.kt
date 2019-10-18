package com.koducation.androidcourse101.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.koducation.androidcourse101.data.remote.model.Stream

@TypeConverters()
@Entity(tableName = "favorite_radios")
data class FavoriteRadioEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "band") val band: String?,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "dial") val dial: String?,
    @ColumnInfo(name = "genres") val genres: List<String>?,
    @ColumnInfo(name = "language") val language: String?,
    @ColumnInfo(name = "listenerCount") val listenerCount: Int = 0,
    @ColumnInfo(name = "logo_big") val logo_big: String?,
    @ColumnInfo(name = "logo_small") val logo_small: String?,
    @ColumnInfo(name = "radioName") val radioName: String?,
    @ColumnInfo(name = "spotUrl") val spotUrl: String?,
    @ColumnInfo(name = "streams") val streams: List<Stream>?,
    @ColumnInfo(name = "website") val website: String?
)
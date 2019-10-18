package com.koducation.androidcourse101.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.koducation.androidcourse101.data.local.entity.FavoriteRadioEntity
import io.reactivex.Flowable

@Dao
abstract class FavoriteRadioDao {

    @Query("SELECT * FROM favorite_radios")
    abstract fun getFavoriteRadios(): Flowable<List<FavoriteRadioEntity>>

    @Insert
    abstract fun insertFavorite(favoriteRadioEntity: FavoriteRadioEntity)

    @Query("DELETE FROM favorite_radios WHERE id=:radioId")
    abstract fun removeFavorite(radioId: Int)

}
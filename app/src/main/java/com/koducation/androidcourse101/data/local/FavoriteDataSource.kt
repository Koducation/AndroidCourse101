package com.koducation.androidcourse101.data.local

import com.koducation.androidcourse101.data.local.entity.FavoriteRadioEntity
import com.koducation.androidcourse101.data.remote.model.Radio
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

class FavoriteDataSource(private val favoriteRadioDao: FavoriteRadioDao) {

    fun getFavoriteList(): Flowable<List<FavoriteRadioEntity>> {
        return Flowable.create(
            { emitter ->
                emitter.onNext(arrayListOf())

                favoriteRadioDao.getFavoriteRadios()
                    .subscribeOn(Schedulers.io())
                    .subscribe {
                        emitter.onNext(it)
                    }
            }, BackpressureStrategy.BUFFER
        )
    }

    fun addToFavorite(radio: Radio): Completable {
        return Completable.create {
            val favoriteRadioEntity = FavoriteRadioEntity(
                radio.id,
                radio.band,
                radio.city,
                radio.country,
                radio.dial,
                radio.genres,
                radio.language,
                radio.listenerCount,
                radio.logo_big,
                radio.logo_small,
                radio.radioName,
                radio.spotUrl,
                radio.streams,
                radio.website
            )
            favoriteRadioDao.insertFavorite(favoriteRadioEntity)
        }
    }

    fun removeFromFavorite(radioId: Int): Completable {
        return Completable.create {
            favoriteRadioDao.removeFavorite(radioId)
        }
    }
}
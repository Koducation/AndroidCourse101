package com.koducation.androidcourse101.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.koducation.androidcourse101.SpotifyRadioApp
import com.koducation.androidcourse101.data.local.FavoriteDataSource
import com.koducation.androidcourse101.data.remote.model.Radio
import io.reactivex.BackpressureStrategy
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(app: Application, val favoriteDataSource: FavoriteDataSource) : AndroidViewModel(app) {

    private val bottomPlayerViewStateLiveData = MutableLiveData<BottomPlayerViewState>()

    private val currentSelectedRadioSubject = BehaviorSubject.create<Radio>()

    private val disposable = CompositeDisposable()

    init {
        disposable.add(
            Flowable
                .combineLatest(
                    currentSelectedRadioSubject.toFlowable(BackpressureStrategy.BUFFER),
                    favoriteDataSource.getFavoriteList(),
                    BottomPlayerViewStateProducer()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { bottomPlayerViewStateLiveData.value = it }
        )
    }

    fun getBottomPlayerViewStateLiveData(): LiveData<BottomPlayerViewState> =
        bottomPlayerViewStateLiveData

    fun setCurrentPlayingRadio(radio: Radio) {
        currentSelectedRadioSubject.onNext(radio)
    }

    fun addToFavorite() {
        bottomPlayerViewStateLiveData.value?.let {
            favoriteDataSource.addToFavorite(it.radio)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
    }

    fun removeFromFavorite() {
        bottomPlayerViewStateLiveData.value?.let {
            favoriteDataSource.removeFromFavorite(it.radio.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        }
    }

    fun isFavorited(): Boolean {
        return bottomPlayerViewStateLiveData.value?.isFavorited ?: false
    }
}
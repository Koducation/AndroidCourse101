package com.koducation.androidcourse101.data

import com.koducation.androidcourse101.data.model.Radio
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RadioDataSource {

    private val radioServiceProvider = RadioServiceProvider()

    fun fetchPopularRadios(): Observable<Resource<List<Radio>>> {
        return Observable.create { emitter ->

            emitter.onNext(Resource.loading())

            radioServiceProvider
                .radioService
                .popularRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        emitter.onNext(Resource.success(it))
                        emitter.onComplete()
                    },
                    {
                        emitter.onNext(Resource.error(it.message ?: "Error"))
                        emitter.onComplete()
                    }
                )
        }
    }

    fun fetchLocationRadios(): Observable<Resource<List<Radio>>> {
        return Observable.create { emitter ->

            emitter.onNext(Resource.loading())

            radioServiceProvider
                .radioService
                .locationRadios()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        emitter.onNext(Resource.success(it))
                        emitter.onComplete()
                    },
                    {
                        emitter.onNext(Resource.error(it.message ?: "Error"))
                        emitter.onComplete()
                    })
        }
    }
}
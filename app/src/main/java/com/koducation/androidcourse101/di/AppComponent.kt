package com.koducation.androidcourse101.di

import com.koducation.androidcourse101.SpotifyRadioApp
import com.koducation.androidcourse101.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AppModule::class,
        DatabaseModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<SpotifyRadioApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<SpotifyRadioApp>

}
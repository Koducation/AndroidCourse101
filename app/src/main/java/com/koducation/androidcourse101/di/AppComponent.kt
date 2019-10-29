package com.koducation.androidcourse101.di

import com.koducation.androidcourse101.SpotifyRadioApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class]
)
interface AppComponent : AndroidInjector<SpotifyRadioApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<SpotifyRadioApp>

}
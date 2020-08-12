package com.example.dailybonus.di


import com.example.dailybonus.App
import com.example.dailybonus.home.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        AppModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {
        @Component.Factory
        interface Factory {
            fun create(appModule: AppModule): ApplicationComponent
        }
 }
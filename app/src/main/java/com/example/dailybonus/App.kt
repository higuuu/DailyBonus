package com.example.dailybonus

import com.example.dailybonus.di.AppModule
import com.example.dailybonus.di.ApplicationComponent
import com.example.dailybonus.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : DaggerApplication(), HasAndroidInjector {

    // 型変数がAnyになる
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    // 返り値の型変数がAnyになる
    override fun androidInjector(): AndroidInjector<Any> {
        DaggerApplicationComponent.factory().create(AppModule(this))
        return androidInjector
    }

    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(AppModule(this))
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationComponent
    }
}
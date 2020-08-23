package com.example.dailybonus.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
        @ContributesAndroidInjector
        fun contributeMainActivityComponent(): MainActivity

        @ContributesAndroidInjector
        abstract fun contributeSettingFragment(): SettingFragment
}
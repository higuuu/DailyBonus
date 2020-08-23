package com.example.dailybonus.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dailybonus.home.SettingViewModel
import javax.inject.Inject

class SettingViewModelFactory @Inject constructor():
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SettingViewModel(
        ) as T
    }
}
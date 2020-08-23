package com.example.dailybonus.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingViewModel @Inject constructor(): ViewModel(){
    private val _settingText: MutableLiveData<String> = MutableLiveData()
    val settingText: LiveData<String> = _settingText

    fun addSettingText(text:String){
        _settingText.postValue(text)
    }
}
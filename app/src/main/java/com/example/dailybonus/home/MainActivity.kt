package com.example.dailybonus.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailybonus.R
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
    }
}

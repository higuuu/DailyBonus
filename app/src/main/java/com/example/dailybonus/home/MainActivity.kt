package com.example.dailybonus.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.dailybonus.R
import com.example.dailybonus.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag, SettingFragment(), "setting")
            .commit()

        binding.bottomNavigation.selectedItemId = R.id.setting
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentInjector
    }

}

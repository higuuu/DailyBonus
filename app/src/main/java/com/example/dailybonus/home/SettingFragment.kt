package com.example.dailybonus.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import com.example.dailybonus.R
import com.example.dailybonus.databinding.FragmentSettingBinding
import com.example.dailybonus.util.SettingViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class SettingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentSettingBinding

    @Inject
    lateinit var factory: SettingViewModelFactory
    private val inputSettingViewModel: SettingViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        // FragmentはonAttachでInjectする
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun addSetting() {
        inputSettingViewModel.addSettingText(binding.editText.text.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate<FragmentSettingBinding>(
                inflater, R.layout.fragment_setting, container, false
            )

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputSettingViewModel.settingText.observe(viewLifecycleOwner, Observer {
            println("aaa")
            binding.settingText.text = it
        })

        binding.button.setOnClickListener {
            addSetting()
            println("touch")
        }

    }

}

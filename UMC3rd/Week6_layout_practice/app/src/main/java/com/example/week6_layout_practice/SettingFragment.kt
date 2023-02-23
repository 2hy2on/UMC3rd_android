package com.example.week6_layout_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6_layout_practice.databinding.FragmentHomeBinding
import com.example.week6_layout_practice.databinding.FragmentSettingBinding

class SettingFragment:Fragment() {
    private lateinit var viewBinding:FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSettingBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}
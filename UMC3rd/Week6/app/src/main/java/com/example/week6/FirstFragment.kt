package com.example.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6.databinding.FragmentFirstBinding
import com.google.android.material.tabs.TabLayoutMediator

class FirstFragment:Fragment() {
    private lateinit var viewBinding:FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFirstBinding.inflate(layoutInflater)
        val mainVPAdapter = MainVPAdapter(this)

        viewBinding.vpMain.adapter = mainVPAdapter

        val tabTitleArray = arrayOf(
            "1",
            "2",
            "3"
        )
        TabLayoutMediator(viewBinding.tabMain,viewBinding.vpMain){ tab,position->
            tab.text = tabTitleArray[position]
        }.attach()
        return viewBinding.root
    }

}
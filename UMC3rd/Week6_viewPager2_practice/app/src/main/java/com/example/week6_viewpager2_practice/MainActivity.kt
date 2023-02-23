package com.example.week6_viewpager2_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_viewpager2_practice.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val mainVPAdapter = MainVPAdapter(this) //djdsdsds
        //어댑터와 실제 view객체 연결
        viewBinding.vpMain.adapter = mainVPAdapter

        val tabTitleArray = arrayOf(
            "One",
            "Two"
        )
        //tab과 연동
        TabLayoutMediator(viewBinding.tabMain,viewBinding.vpMain){ tab,position->
            tab.text = tabTitleArray[position]
        }.attach()

    }
}
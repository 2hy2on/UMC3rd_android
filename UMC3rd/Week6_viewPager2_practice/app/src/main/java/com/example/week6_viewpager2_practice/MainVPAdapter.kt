package com.example.week6_viewpager2_practice

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//fragmentactivity일반적으로 우리가 사용하는 activity임
class MainVPAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) { //AppcompatActivity가 fragment activity 상속
    override fun getItemCount(): Int = 2//아이템갯수

    override fun createFragment(position: Int): Fragment { //포지션에 따라 어떤 fragment보여줄지 설정
        return when(position){
            0-> OneFragment()
            1->TwoFragment()
            else->OneFragment()
        }
    }

}
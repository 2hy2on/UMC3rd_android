package com.example.week6_viewpager2_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6_viewpager2_practice.databinding.FragmentOneBinding

class OneFragment:Fragment() {
    private lateinit var viewBinding:FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentOneBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}
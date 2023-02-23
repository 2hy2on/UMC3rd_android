package com.example.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6.databinding.FragmentFirstBinding
import com.example.week6.databinding.FragmentThirdBinding

class ThirdFragment:Fragment() {
    private lateinit var viewBinding:FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThirdBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}
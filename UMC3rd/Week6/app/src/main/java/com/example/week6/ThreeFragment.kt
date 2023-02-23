package com.example.week6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.week6.databinding.FragmentOneBinding
import com.example.week6.databinding.FragmentThreeBinding

class ThreeFragment: Fragment() {
    private lateinit var viewBinding: FragmentThreeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentThreeBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}
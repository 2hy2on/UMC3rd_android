package com.example.week4_lifecycle_practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week4_lifecycle_practice.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtSecond.text = intent.getStringExtra("data")
    }
}
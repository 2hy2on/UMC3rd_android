package com.example.week3_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_practice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


        val extras = intent.extras
        val data = extras!!["text"] as String//!!는 무조건 넘어온다.

        viewBinding.tvSecondText.text = data
    }
}
package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week2.databinding.ActivityMainBinding
import com.example.week2.databinding.ActivitySearchBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}
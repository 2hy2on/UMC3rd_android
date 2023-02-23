package com.example.week3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week3_1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras
        val content = extras!!["content"].toString()

        viewBinding.tvSecondText.text = content
        //viewBinding.tvSecondText.text = intent.getStringExtra("content")

        viewBinding.btnToThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity ::class.java)
            startActivity(intent)
        }
    }
}
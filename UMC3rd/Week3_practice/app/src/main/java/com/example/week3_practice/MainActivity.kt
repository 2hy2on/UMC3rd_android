package com.example.week3_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding //타입설정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater) //xml파일 해석하겠다
        setContentView(viewBinding.root) //layout의 가장 위
        
        viewBinding.btnNext.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("text", "first")
            startActivity(intent)
        }
    }
}
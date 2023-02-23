package com.example.week4_lifecycle_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.week4_lifecycle_practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //메모리에 올려줌
        setContentView(binding.root)

        binding.btnMain.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("data", binding.edtMain.text.toString())
            startActivity(intent)

        }
        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart",Toast.LENGTH_SHORT)
    }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume",Toast.LENGTH_SHORT)
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause",Toast.LENGTH_SHORT)
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop",Toast.LENGTH_SHORT)
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart",Toast.LENGTH_SHORT)
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy",Toast.LENGTH_SHORT)
    }
}
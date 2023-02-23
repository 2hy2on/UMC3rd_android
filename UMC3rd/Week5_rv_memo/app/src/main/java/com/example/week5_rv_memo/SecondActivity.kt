package com.example.week5_rv_memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week5_rv_memo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.saveBtn.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("title", viewBinding.etTitle.text.toString())
                putExtra("desc", viewBinding.etDesc.text.toString())
            }
            setResult(RESULT_OK,mIntent)
            finish()
        }
    }
}
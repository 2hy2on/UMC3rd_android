package com.example.week3_practice2_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week3_practice2_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager //관리
            .beginTransaction() //변경되는거 시작
            .replace(viewBinding.frameFragment.id, FirstFragment()) //add는 겹침
            .commitAllowingStateLoss() //샃애가 날라간느 것 허용 오류 방지

        viewBinding.btnFragment1.setOnClickListener{
            supportFragmentManager //관리
                .beginTransaction() //변경되는거 시작
                .replace(viewBinding.frameFragment.id, FirstFragment()) //add는 겹침
                .commitAllowingStateLoss() //상태 간느 것 허용 오류 방지
        }

        viewBinding.btnFragment2.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.frameFragment.id, SecondFragment())
                .commitAllowingStateLoss()
        }
    }
}
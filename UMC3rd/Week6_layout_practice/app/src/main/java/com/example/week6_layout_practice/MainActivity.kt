package com.example.week6_layout_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6_layout_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.cotainerFragment.id, HomeFragment())
            .commitAllowingStateLoss() //가끔 그냥 commit쓰면 에러뜸

        viewBinding.navBottom.run { //범위함수
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_home->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.cotainerFragment.id, HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.cotainerFragment.id, SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            //초기에 설정한걸 버텀nav에 알려주기 위해
            selectedItemId = R.id.menu_home
        }
    }
}
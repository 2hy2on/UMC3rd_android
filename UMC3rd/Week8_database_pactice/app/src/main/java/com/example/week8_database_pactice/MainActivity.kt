package com.example.week8_database_pactice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week8_database_pactice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)


        val roomDb = AppDatabase.getInstance(this)

        if(roomDb != null){
//            val user = User("시니", 21)
//            roomDb.userDao().insert(user)

            roomDb.userDao().updateNameByUserId(1,"시니")
            val userList = roomDb.userDao().selectAll()
            Log.d("DB", "User List: ${userList}")
        }
//        //fragment에서 사용하려면 context붙이기 지금은 activity이기 때문에 안붙임
//        val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
//        //값을 수정하기 위한 객체 =에디터
//        val editor = sharedPrefs.edit()
//
//        //이 코드는 무시(초기화용)
//        editor.putString("시니", "")
//        editor.apply()
//        //이 코드는 무시(초기화용)
//
//        editor.putString("시니", "android")
//        val beforeapplyvalue = sharedPrefs.getString("시니", "")
//        Log.d("SP before", "${beforeapplyvalue}")
//
//        editor.apply() // 저장!
//
//        val spvalue = sharedPrefs.getString("시니", "") //이 값이 없을 때 빈값을 넣어줘라
//        Log.d("SP", "${spvalue}")


    }
}
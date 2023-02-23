package com.example.week9_api_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week9_api_practice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //웹브라우저 창만 엶
        val retrofit = Retrofit.Builder()
//            .baseUrl() //서버 적기
            .addConverterFactory(GsonConverterFactory.create()) // json형태를 객체형태로 바꿔줌
            .build()
        
        //어떤 주소를 입력했다!!, 아직 요청은 안보냄
        val apiService = retrofit.create(ApiService::class.java) //인터페이스와 레트로핏 연결
        
        //입력한 주소 중에 하나로 연결 시도
        apiService.getCheckEmail("abc.com").enqueue(object: Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                if(response.isSuccessful){
                    val responseData = response.body()

                    if(responseData != null)
                        Log.d("Retrofit","response\ncode: ${responseData.code}")

                }
                else{
                    Log.w("retrofit", "${response.code()}")
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("retrofit","error", t)
            }

        }) //큐에 넣기 비동기적으로 작동을 위해(백그라운드에 작동 되어야함)
    }
}
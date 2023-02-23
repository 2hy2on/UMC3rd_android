package com.example.week9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.week9.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        Log.d("test", "test")
        val CLIENT_ID = "zNDtrlF_sspL6T47yVPn"
        val CLIENT_SECRET = "9QW0enAWzt"
        val Base_URL_NAVER_API = "https://openapi.naver.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL_NAVER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(NaverAPI::class.java)
        val callGetSearchNews = api.getSearchNews(CLIENT_ID,CLIENT_SECRET,"테스트")

        callGetSearchNews.enqueue(object : Callback<ResultGetSearchNews>{
            override fun onResponse(
                call: Call<ResultGetSearchNews>,
                response: Response<ResultGetSearchNews>
            ) {
                viewBinding.tv.text = response.raw().toString()
                Log.d("결과","성공: ${response.raw()}")
            }

            override fun onFailure(call: Call<ResultGetSearchNews>, t: Throwable) {
                Log.d("결과: ","실패 : $t")
            }
        })
    }
}
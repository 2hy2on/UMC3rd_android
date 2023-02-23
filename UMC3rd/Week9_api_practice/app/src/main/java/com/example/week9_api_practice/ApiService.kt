package com.example.week9_api_practice

import android.telecom.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("app/users/email-check") //쿼리스트링 빼줘야함, 앞에 /도 뺴
    fun getCheckEmail(
        @Query("email") email:String //매개변수작성
        //리턴차입 개체로

    ): Call<Response>
}
package com.example.week7_thread_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.week7_thread_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val imageList: ArrayList<Int> = arrayListOf(
            R.drawable.threadtest_1,
            R.drawable.threadtest_2,
            R.drawable.threadtest_3,
            R.drawable.threadtest_4,
            R.drawable.threadtest_5,
        )
        var imgIdx = 0

        val handler = Handler(mainLooper)

        Thread(){
            while(true){
                if(imgIdx == imageList.size - 1){
                    imgIdx = 0
                }else{
                    imgIdx++
                }

                //Hanlder.post ->여기서 하기 힘드니까 handler가 있는 쓰레드 (UI Thread)에서 해줘~
                handler.post{
                    viewBinding.ivImage.setImageResource(imageList[imgIdx])
                }
                Thread.sleep(2000)
            }
        }.start()
    }
}
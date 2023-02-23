package com.example.week7

import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.core.app.NotificationCompat
import com.example.week7.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding:ActivityMainBinding
    private  lateinit var notificationHelper: NotificationHelper
    var running = true
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SoundPool.Builder().build()
        } else {
            TODO("VERSION.SDK_INT < LOLLIPOP")
        }

        val soundId = soundPool.load(this, R.raw.sound2, 1)


        viewBinding.startBtn.setOnClickListener {
            running = true
            var sec = Integer.parseInt(viewBinding.sec.text.toString())
            val handler = Handler(mainLooper)
            Thread() {
                while (running) {
                    if (sec == 0) {
                        setNotification()
                        soundPool.play(soundId, 1.0f, 1.0f, 0, 3, 1.0f)
                        running = false
                    } else {
                        sec--;
                    }
                    handler.post {
                        viewBinding.sec.setText(sec.toString())
                    }
                    Thread.sleep(1000)
                }
            }.start()
        }
    }
    private fun setNotification(){
        notificationHelper = NotificationHelper(this)

        //알림호출
        showNotification("타이머", "타이머 종료")
    }
    private fun showNotification(title: String, message: String){

        val nb: NotificationCompat.Builder = notificationHelper.getChannelNotification(title, message)

        notificationHelper.getManager().notify(1,nb.build())
    }

}
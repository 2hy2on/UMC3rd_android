package com.example.week8_database_pactice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version=1) //데이터베이스와 객체 연결, 버전 넣어!
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao():UserDao //RoomDatabase 상속 받았기 때문에 자동으로
    companion object{
        private var appDatabase: AppDatabase? = null //널허용

        @Synchronized ///효율적으로 객체를 재활용하는 방법
        fun getInstance(context: Context): AppDatabase?{ //룸 디비를 가져올 때 context필요
            if(appDatabase == null){
                synchronized(AppDatabase::class.java){ //이클래스가 점유를 하고있다.
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, //지금 룸 데이터베이스 객체 자체
                    "app-database" //이름 겹치면 안됨..
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}
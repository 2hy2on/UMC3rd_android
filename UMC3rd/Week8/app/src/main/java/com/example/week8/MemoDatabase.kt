package com.example.week8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version=1) //데이터베이스와 객체 연결, 버전 넣어!
abstract class MemoDatabase: RoomDatabase() {
    abstract fun memoDao():MemoDao //RoomDatabase 상속 받았기 때문에 자동으로

    companion object{
        private var appDatabase: MemoDatabase? = null //널허용

        @Synchronized ///효율적으로 객체를 재활용하는 방법
        fun getInstance(context: Context): MemoDatabase?{ //룸 디비를 가져올 때 context필요
            if(appDatabase == null){
                synchronized(MemoDatabase::class.java){ //이클래스가 점유를 하고있다.
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        MemoDatabase::class.java, //지금 룸 데이터베이스 객체 자체
                    "memo-database" //이름 겹치면 안됨..
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}
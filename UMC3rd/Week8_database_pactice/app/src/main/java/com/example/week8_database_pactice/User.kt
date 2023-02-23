package com.example.week8_database_pactice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //룸디비에서 쓰는 객체다 알려줌!
data class User(
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="age") val age: Int,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="userId") val userId: Int = 0// 같은 값 가질 수 없음(데이터베이스 내에서)
)

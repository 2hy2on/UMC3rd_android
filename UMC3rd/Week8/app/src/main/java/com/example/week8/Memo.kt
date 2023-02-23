package com.example.week8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //룸디비에서 쓰는 객체다 알려줌!
data class Memo(
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="desc") val desc: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") val userId: Int = 0// 같은 값 가질 수 없음(데이터베이스 내에서)
)

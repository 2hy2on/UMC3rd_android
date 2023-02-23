package com.example.week8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDao {
    @Insert
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("SELECT * FROM Memo") //User테이블에 있는 정보를 가져오겠다.
    fun selectAll(): List<Memo>

    @Query("SELECT title FROM Memo WHERE ID = :id ")
    fun selectTitleByID(id: Int): String

    @Query("SELECT `desc` FROM Memo WHERE ID = :id")
    fun selectDescByID(id: Int):String

    @Query("SELECT COUNT(*) FROM Memo")
    fun getCountMemo(): Int
}
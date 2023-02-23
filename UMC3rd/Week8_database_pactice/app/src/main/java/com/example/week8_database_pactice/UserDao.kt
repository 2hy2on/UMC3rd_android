package com.example.week8_database_pactice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM User") //User테이블에 있는 정보를 가져오겠다.
    fun selectAll(): List<User>

    @Query("Select * FROM User WHERE userId = :userId")
    fun selectByUserId(userId:Int): User //단일값

    @Query("SELECT * FROM User WHERE name = :name")
    fun selectByUserName(name: String): List<User>

    @Query("UPDATE User SET name = :name WHERE userId = :userId")
    fun updateNameByUserId(userId:Int, name: String)


}
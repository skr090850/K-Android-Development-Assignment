package com.example.authappusingkotlin

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user_table")
    suspend fun getAllUser(): List<UserData>

    @Insert
    suspend fun insertUser(user: UserData)

    @Query("SELECT * FROM user_table where emaiId = :email AND pass = :password LIMIT 1")
    suspend fun findUser(email: String, password: String): UserData?
}
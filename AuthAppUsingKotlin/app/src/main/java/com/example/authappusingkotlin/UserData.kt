package com.example.authappusingkotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fullName: String,
    val emaiId: String,
    val pass: String,
    val confPass: String
)
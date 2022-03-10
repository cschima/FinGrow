package com.example.fingrow.data

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val email: String,
    val password: String
)

/*

General Tables:
Users
Assignments

Per Client:
Money Flow
Meetings
Chat
Goals
Files

*/
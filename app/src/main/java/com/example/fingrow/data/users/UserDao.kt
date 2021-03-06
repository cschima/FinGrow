package com.example.fingrow.data.users

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    // OnConflictStrategy.IGNORE: if there is exactly the same user, then ignore it
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(user: User)

    @Transaction
    @Query("SELECT COUNT(*) FROM users_table")
    suspend fun userCount(): Int

    @Transaction
    @Query("SELECT * FROM users_table WHERE email = :email")
    suspend fun findUser(email: String): User?

    @Delete
    fun delete(user: User)

    @Transaction
    @Query("SELECT * FROM users_table")
    fun readAllUserData(): LiveData<List<User>>

    @Update
    suspend fun updateUser(user: User)
}
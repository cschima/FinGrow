package com.example.fingrow.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    // OnConflictStrategy.IGNORE: if there is exactly the same user, then ignore it

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Delete
    fun delete(user:User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllUserData(): LiveData<List<User>>

//    @Query("SELECT * FROM user_assignments_table WHERE userName = :userName")
//    fun readAllUserAssignmentsData(userName: String): LiveData<List<UserAssignments>>

    // Transactions makes sure there aren't any multithreading issues
    @Transaction
    @Query("SELECT * FROM user_table WHERE userName = :userName")
    fun getUserData(userName: String): LiveData<List<User>>

}
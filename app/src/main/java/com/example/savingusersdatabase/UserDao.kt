package com.example.savingusersdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user:User)
    @Query("SELECT * FROM user_table")
    fun getAllUsers():LiveData<List<User>>
}
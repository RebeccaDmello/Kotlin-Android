package com.example.midterm_300322984.dbUser

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // it performs an update if it exists
    fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM UserAccounts")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("DELETE from UserAccounts")
    fun deleteAll()

    @Query("SELECT * FROM UserAccounts WHERE fullname = :fullname") // :id refers to the parameter
    fun getUserByfullname(fullname: String): UserEntity?

    @Query("SELECT * FROM UserAccounts WHERE firstname = :firstname") // :id refers to the parameter
    fun getUserByfirstname(firstname: String): List<UserEntity>

    @Query("SELECT * FROM UserAccounts WHERE jobPostingId = :jobPostingId") // :id refers to the parameter
    fun getUserByjobpostingid(jobPostingId: Int): List<UserEntity>

}
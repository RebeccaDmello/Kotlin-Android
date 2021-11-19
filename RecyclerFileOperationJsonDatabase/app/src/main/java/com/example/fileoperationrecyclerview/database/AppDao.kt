package com.example.fileoperationrecyclerview.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fileoperationrecyclerview.database.model.Employee

@Dao
interface AppDao {

    @Insert
    fun insertEmployees(vararg emp: Employee): List<Long>

    @Delete
    fun deleteEmployees(vararg emp: Employee): Int

    @Query("Select * FROM employee")
    fun getAllEmployees(): MutableList<Employee>
}
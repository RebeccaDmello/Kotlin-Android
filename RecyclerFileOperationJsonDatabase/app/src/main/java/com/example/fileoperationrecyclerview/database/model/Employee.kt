package com.example.fileoperationrecyclerview.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "employee")
data class Employee (
    @PrimaryKey val id: Int = 0,
    @Json(name = "first_name") @ColumnInfo(name = "first_name") val firstName : String = "",
    @Json(name = "last_name") @ColumnInfo(name = "last_name") val lastName : String = "",
    @Json(name = "gender") @ColumnInfo(name = "gender") val gender: String?
    )

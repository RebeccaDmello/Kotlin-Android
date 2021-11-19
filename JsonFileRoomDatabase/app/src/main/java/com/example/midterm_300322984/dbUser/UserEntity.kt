package com.example.midterm_300322984.dbUser

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "UserAccounts")
class UserEntity (
    @PrimaryKey
    var fullname : String,
    @Json(name = "firstname") var firstname : String,
    @Json(name = "lastname") var lastname : String,
    @Json(name = "login") var login : String,
    @Json(name = "password") var password : String,
    @Json(name = "jobPostingId") var jobPostingId : Int,
)
package com.example.fileoperationrecyclerview.utilities

import androidx.room.TypeConverter
import java.util.*

class CustomTypeConverters {
    companion object{
        @TypeConverter
        @JvmStatic
        fun fromList(value: List<String>): String{
            return value.joinToString(separator = ",")
        }

        @TypeConverter
        @JvmStatic
        fun toList(value: String): List<String>{
            return value.split(",")
        }

        @TypeConverter
        @JvmStatic
        fun fromTimeStamp(value: Long?): Date?{
            return value?.let{Date(it)}
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?):Long?{
            return date?.time?.toLong()
        }
    }
}
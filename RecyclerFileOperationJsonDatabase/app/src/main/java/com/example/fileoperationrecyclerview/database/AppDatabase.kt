package com.example.fileoperationrecyclerview.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fileoperationrecyclerview.database.model.Employee

@Database(
    entities = [Employee::class], version = 1, exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            var tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "movie"
                ).allowMainThreadQueries().fallbackToDestructiveMigrationOnDowngrade().fallbackToDestructiveMigration().build()

                INSTANCE = instance
                return instance
            }
        }
    }

}
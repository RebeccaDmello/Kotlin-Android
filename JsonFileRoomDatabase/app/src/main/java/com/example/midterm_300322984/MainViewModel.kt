package com.example.midterm_300322984

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm_300322984.db.AppDatabase
import com.example.midterm_300322984.db.JobEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(app: Application) : AndroidViewModel(app){

    private val database = AppDatabase.getInstance(app)

    val jobList = database?.jobDao()?.getAll()   // getAll is defined in JobDao

    //adding data into the database
    fun addData(jobList : List<JobEntity>?) {
        viewModelScope.launch {
            // Dispatchers.IO means run this in the background
            withContext(Dispatchers.IO) {
                if (jobList != null) {
                    database?.jobDao()?.insertAll(jobList)
                }
            }
        }
    }

//    fun deleteJobs(selectedNotes: List<JobEntity>) {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                database?.jobDao()?.deleteJobs(selectedNotes)
//            }
//        }
//
//    }
//
//    fun deleteAllJobs() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                database?.jobDao()?.deleteAll()
//            }
//        }
//    }
}
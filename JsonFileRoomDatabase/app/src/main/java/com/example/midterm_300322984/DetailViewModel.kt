package com.example.midterm_300322984

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.midterm_300322984.db.AppDatabase
import com.example.midterm_300322984.db.JobEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.Year

class DetailViewModel(app: Application) : AndroidViewModel(app) {

    private val database = AppDatabase.getInstance(app)
    val jobList = database?.jobDao()?.getAll()
    var currentJob : MutableLiveData<JobEntity>? = MutableLiveData<JobEntity>()

    fun getJobByJobId(JobId: Int){

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val job = database?.jobDao()?.getJobByJobId(JobId)

                if(job!=null){
                    currentJob?.postValue(job!!)
                }

            }
        }

    }
}
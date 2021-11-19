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

class SearchResultsViewModel (app: Application) : AndroidViewModel(app) {
    private val database = AppDatabase.getInstance(app)
    val jobList = database?.jobDao()?.getAll()
    var searchedJobs = MutableLiveData<List<JobEntity>>()

    fun getJOBSById(searchType: Int, searchValue: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                if(searchType == 4){
                    var jobCat : String = searchValue
                    searchedJobs.postValue(database?.jobDao()?.getJobByJobCategory(jobCat))

                }
                if(searchType == 3){
                    var jobPostingType : String = searchValue
                    searchedJobs.postValue(database?.jobDao()?.getJobByPostingType(jobPostingType))
                }
                if(searchType == 2){
                    var jobP : String = searchValue
                    searchedJobs.postValue(database?.jobDao()?.getJobByFtPt(jobP))
                }
                if(searchType == 1){
                    var jobF : String = searchValue
                    searchedJobs.postValue(database?.jobDao()?.getJobByFtPt(jobF))
                }
            }
        }
    }
}
package com.example.midterm_300322984

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.midterm_300322984.db.AppDatabase

class SearchViewModel(app: Application) : AndroidViewModel(app) {

    private val database = AppDatabase.getInstance(app)

    val jobList = database?.jobDao()?.getAll()
}
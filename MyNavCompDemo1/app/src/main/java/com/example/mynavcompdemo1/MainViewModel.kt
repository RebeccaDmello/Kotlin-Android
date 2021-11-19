package com.example.mynavcompdemo1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val notesList = MutableLiveData<List<NoteEntity>>()

    init {
        println("2. init - MainViewModel")
        notesList.value = SampleDataProvider.getNotes()
    }
}
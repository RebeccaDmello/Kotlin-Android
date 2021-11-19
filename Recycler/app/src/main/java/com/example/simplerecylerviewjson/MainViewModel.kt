package com.example.simplerecylerviewjson

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val datasList = MutableLiveData<List<DataEntity>>()

    init{
        datasList.value = SampleDataProvider.getNotes()
    }
}
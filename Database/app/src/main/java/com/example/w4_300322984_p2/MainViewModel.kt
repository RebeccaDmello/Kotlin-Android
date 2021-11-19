package com.example.w4_300322984_p2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.w4_300322984_p2.NoteEntity
import com.example.w4_300322984_p2.SampleDataProvider

class MainViewModel : ViewModel() {
    val notesList = MutableLiveData<MutableList<NoteEntity>>()

    init {
        notesList.value = SampleDataProvider.getNotes()
    }

    fun addNewNote(newNote : NoteEntity){
        notesList.value?.add(newNote)
    }
}
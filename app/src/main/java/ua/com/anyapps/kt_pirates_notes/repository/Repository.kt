package ua.com.anyapps.kt_pirates_notes.repository

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

class Repository {
    fun getData(): MutableLiveData<String>{
        var noteTitle = MutableLiveData<String>("213")
        return noteTitle
    }
}
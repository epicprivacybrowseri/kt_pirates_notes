package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class ListOfNotesViewModel(): ViewModel(){
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    val notesList = repository.notesList
}
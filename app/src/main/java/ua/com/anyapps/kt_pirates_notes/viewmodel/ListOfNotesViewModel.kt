package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.ENote
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class ListOfNotesViewModel(): ViewModel(){
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    val data = repository.data

    //var notes1: LiveData<MutableList<Note>> = repository.getNotes()

    //private val _notes = MutableLiveData<List<Note>>().apply { value = emptyList() }
    //val notes = MutableLiveData<List<ENote>>().apply { value = emptyList() }

    init{
        //notes.value = repository.getNotes()
    }

    fun loadNotesList() {
        //notes.value = repository.getNotes()
    }
}
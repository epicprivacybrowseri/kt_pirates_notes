package ua.com.anyapps.kt_pirates_notes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.contract.MainActivityContract
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class ListOfNotesViewModel(): ViewModel(), MainActivityContract.ListOfNotesViewModel {
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    //var notes1: LiveData<MutableList<Note>> = repository.getNotes()

    //private val _notes = MutableLiveData<List<Note>>().apply { value = emptyList() }
    val notes = MutableLiveData<List<Note>>().apply { value = emptyList() }

    init{
        notes.value = repository.getNotes()
    }

    override fun loadNotesList() {
        //notes.value = repository.getNotes()
    }
}
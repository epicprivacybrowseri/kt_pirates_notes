package ua.com.anyapps.kt_pirates_notes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.repository.Repository
import ua.com.anyapps.kt_pirates_notes.repository.RepositoryImpl
import ua.com.anyapps.kt_pirates_notes.utils.TAG

class ListOfNotesViewModel(): ViewModel(){
    private val repository: Repository = RepositoryImpl()

    fun getNoteListObservable(): LiveData<List<NoteModel>> {
        return repository.getAll()
    }
}
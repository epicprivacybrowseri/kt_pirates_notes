package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.repository.Repository
import ua.com.anyapps.kt_pirates_notes.repository.RepositoryImpl

class ListOfNotesViewModel() : ViewModel() {

    private val repository: Repository = RepositoryImpl()

    fun getNoteListObservable(): LiveData<List<NoteModel>> {
        return repository.getAll()
    }

    fun getNoteById(): LiveData<NoteModel>{
        return repository.getById("1")
    }
}
package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.repository.NoteRepository
import ua.com.anyapps.kt_pirates_notes.repository.NoteRepositoryImpl

class ListOfNotesViewModel() : ViewModel() {

    private val repository: NoteRepository = NoteRepositoryImpl()

    fun getNoteListObservable(): LiveData<List<NoteModel>> {
        return repository.getAll()
    }

    fun getNoteById(): LiveData<NoteModel>{
        return repository.getById("1")
    }
}
package ua.com.anyapps.kt_pirates_notes.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.repository.NoteRepository
import ua.com.anyapps.kt_pirates_notes.repository.NoteRepositoryImpl
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import javax.inject.Inject

class ListOfNotesViewModel() : ViewModel() {

    private val repository: NoteRepository = NoteRepositoryImpl()

    fun getNoteListObservable(): LiveData<List<NoteModel>> {
        return repository.getAll()
    }

    fun getNoteById(): LiveData<NoteModel>{
        return repository.getById("1")
    }
}
package ua.com.anyapps.kt_pirates_notes.repository

import androidx.lifecycle.MutableLiveData
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity

interface Repository {
    fun getById(id: String): MutableLiveData<NoteModel>
    suspend fun insert(note: NoteEntity)
    fun getAll(): MutableLiveData<List<NoteModel>>
}
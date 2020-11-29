package ua.com.anyapps.kt_pirates_notes.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.utils.TAG
import javax.inject.Inject

interface Repository{
    fun getById(id: String): NoteEntity
    suspend fun insert(note: NoteEntity)
    fun getAll(): LiveData<List<NoteEntity>>
}
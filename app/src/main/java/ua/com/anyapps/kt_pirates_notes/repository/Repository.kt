package ua.com.anyapps.kt_pirates_notes.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import javax.inject.Inject


class Repository{
    val TAG: String = "debapp"
    @Inject lateinit var appDatabase: AppDatabase
    @Inject lateinit var context: Context
    init{
        App.applicationComponent.inject(this)
    }

    lateinit var noteTitle:MutableLiveData<String>

    val notesList = appDatabase.noteDAO().getAll()

    fun getById(id: String): Note {
        val note: Note = Note("Title1", "Text1")
        return note
    }

    suspend fun insert(note: Note) {
        Log.d(TAG, "INSERTED ${note.title} ${note.text}" )
        appDatabase.noteDAO().insert(note)
    }
}
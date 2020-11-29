package ua.com.anyapps.kt_pirates_notes.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.utils.TAG
import javax.inject.Inject


class RepositoryImpl(): Repository{
    @Inject lateinit var appDatabase: AppDatabase
    @Inject lateinit var context: Context
    init{
        App.applicationComponent.inject(this)
    }

    override  fun getById(id: String): NoteEntity {
        val note: NoteEntity = NoteEntity("Title1", "Text1")
        return note
    }

    override  suspend fun insert(note: NoteEntity) {
        Log.d(TAG, "INSERTED ${note.title} ${note.text}" )
        appDatabase.noteDAO().insert(note)
    }

    override  fun getAll(): LiveData<List<NoteEntity>> {

        //appDatabase.noteDAO().getAll().observe(this, sfsdf)
        //возвращать модель
        return appDatabase.noteDAO().getAll()
    }
}


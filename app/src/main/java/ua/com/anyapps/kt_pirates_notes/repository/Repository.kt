package ua.com.anyapps.kt_pirates_notes.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.model.ENote
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
    fun getData(): MutableLiveData<String>{
        noteTitle = MutableLiveData<String>("213")
        return noteTitle
    }

    val data = appDatabase.noteDAO().getAll()
    /*fun getNotes(): MutableList<Note> {

        /*val note1: Note = Note("Title1111", "Text1")
        val note2: Note = Note("Title21111111111", "Text2")
        val notes: MutableList<Note> = arrayListOf(note1, note2)
        val result = MutableLiveData<MutableList<Note>>()
        result.value = notes
        return notes*/
        var list = mutableListOf<Note>()
        appDatabase.noteDAO().getAll().forEach { eNote: ENote ->
            var n:Note = Note(eNote.title, eNote.text)
            list.add(n)
        }

        val result = MutableLiveData<MutableList<Note>>()
        //result.value = notes
        return list
    }*/

    fun getById(id: String): ENote {
        val note: ENote = ENote("Title1", "Text1")
        return note
    }

    fun insert(note: ENote) {
        suspend fun refresh() {
            withContext(Dispatchers.IO) {
                Log.d(TAG, "INSERTED ${note.title} ${note.text}" )
                var eNote: ENote = ENote(note.title, note.text)
                appDatabase.noteDAO().insert(eNote)
            }
        }
    }
}
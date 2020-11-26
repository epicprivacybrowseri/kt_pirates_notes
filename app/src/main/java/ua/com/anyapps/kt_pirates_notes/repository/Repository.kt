package ua.com.anyapps.kt_pirates_notes.repository

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ua.com.anyapps.kt_pirates_notes.contract.MainActivityContract
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.model.ENote
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO
import javax.inject.Inject


class Repository: MainActivityContract.Repository {
    val TAG: String = "debapp"
    @Inject lateinit var appDatabase: AppDatabase
    init{
        App.applicationComponent.inject(this)
    }

    lateinit var noteTitle:MutableLiveData<String>
    fun getData(): MutableLiveData<String>{
        noteTitle = MutableLiveData<String>("213")
        return noteTitle
    }

    override fun getNotes(): MutableList<Note> {
        /*val note1: Note = Note("Title1111", "Text1")
        val note2: Note = Note("Title21111111111", "Text2")
        val notes: MutableList<Note> = arrayListOf(note1, note2)
        val result = MutableLiveData<MutableList<Note>>()
        result.value = notes
        return notes*/

    }

    override fun getById(id: String): Note {
        val note: Note = Note("Title1", "Text1")
        return note
    }

    override fun insert(note: Note) {
        Log.d(TAG, "INSERTED ${note.noteTitle} ${note.noteTitle}" )
        var eNote: ENote = ENote(note.noteTitle, note.noteTitle)
        appDatabase.noteDAO().insert(eNote)
    }
}
package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.repository.Repository
import ua.com.anyapps.kt_pirates_notes.repository.RepositoryImpl

class ListOfNotesViewModel(): ViewModel(){
    val repository: Repository = RepositoryImpl()

    private val _notes = MutableLiveData<List<NoteModel>>().apply { value = emptyList() }
    val notes: LiveData<List<NoteModel>> = _notes

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    //val notesList = repository.notesList
    //private val _notesList = repository.getAll()
    //val notesList: LiveData<List<NoteEntity>> = _notesList

    fun loadNotes() {
        //_notes.value = repository.getAll().value
        val notesList: List<NoteModel> = arrayListOf(
                NoteModel("t1", "t1", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 1),
                NoteModel("t2", "t2", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 2),
                NoteModel("t3", "t3", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 3),
                NoteModel("t4", "t4", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 4),
                NoteModel("t5", "t5", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 5)
        )
        _notes.value = notesList
    }
}
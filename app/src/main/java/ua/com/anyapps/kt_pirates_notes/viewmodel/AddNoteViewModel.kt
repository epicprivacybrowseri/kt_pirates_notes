package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.com.anyapps.kt_pirates_notes.repository.NoteRepositoryImpl
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity

class AddNoteViewModel() : ViewModel() {

    private val repository: NoteRepositoryImpl = NoteRepositoryImpl()

    fun btnSaveClick(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}
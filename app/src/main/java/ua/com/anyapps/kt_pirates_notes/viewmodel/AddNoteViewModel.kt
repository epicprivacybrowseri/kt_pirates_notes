package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.repository.RepositoryImpl

class AddNoteViewModel() : ViewModel(){
    val repository: RepositoryImpl = RepositoryImpl()

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    fun btnSaveNoteClicked(note: NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

}
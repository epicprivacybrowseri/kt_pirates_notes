package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class AddNoteViewModel() : ViewModel(){
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    fun btnSaveNoteClicked(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

}
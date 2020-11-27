package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ua.com.anyapps.kt_pirates_notes.model.ENote
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class AddNoteViewModel() : ViewModel(){
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    //var noteTitle = MutableLiveData<String>()

    lateinit var info2: MutableLiveData<String>
    init {
        //noteTitle.value = "33333333"
        info2 = repository.getData()
        /*info.observe(this, Observer{str: String?->
            Log.d(TAG, "Title2222: " + str)
        })*/

    }

    //var noteTitle = MutableLiveData<String>()
    //var noteText = MutableLiveData<String>()

    //var info = ObservableField<String>("times..")

    fun btnSaveNoteClicked(note: ENote) = viewModelScope.launch {
        repository.insert(note)
        //_onMessageError.value = "error!!!"
    }

}
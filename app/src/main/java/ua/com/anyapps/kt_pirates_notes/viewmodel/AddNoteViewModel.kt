package ua.com.anyapps.kt_pirates_notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.contract.MainActivityContract
import ua.com.anyapps.kt_pirates_notes.model.ENote
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class AddNoteViewModel() : ViewModel(), MainActivityContract.AddNoteViewModel {
    val repository: Repository = Repository()
    val TAG: String = "debapp"

    var notes: LiveData<MutableList<Note>> = repository.getNotes()
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

    override fun btnSaveNoteClicked(note: Note) {
        repository.insert(note)
    }

}
package ua.com.anyapps.kt_pirates_notes.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.repository.Repository

class AddNoteViewModel() : ViewModel() {
    val repo: Repository = Repository()
    var noteTitle = MutableLiveData<String>()

    lateinit var info2: MutableLiveData<String>
    init {
        noteTitle.value = "33333333"

        info2 = repo.getData()
        /*info.observe(this, Observer{str: String?->
            Log.d(TAG, "Title2222: " + str)
        })*/

    }
    val TAG: String = "debapp"
    //var noteTitle = MutableLiveData<String>()
    var noteText = MutableLiveData<String>()

    var info = ObservableField<String>("times..")

    fun btnSaveNoteClick() {
        //noteTitle.value =
    }

}
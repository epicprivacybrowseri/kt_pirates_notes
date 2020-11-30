package ua.com.anyapps.kt_pirates_notes.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ua.com.anyapps.kt_pirates_notes.di.App
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.room.AppDatabase
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.utils.TAG
import javax.inject.Inject

class RepositoryImpl() : Repository {
    @Inject
    lateinit var appDatabase: AppDatabase
    @Inject
    lateinit var context: Context

    init {
        App.applicationComponent.inject(this)
    }

    override fun getById(id: String): MutableLiveData<NoteModel> {
        val mutableLiveData = MutableLiveData<NoteModel>()
        
        val note: NoteModel = NoteModel("Title1", "Text1", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 1)
        mutableLiveData.value = note

        return mutableLiveData
    }

    override suspend fun insert(note: NoteEntity) {
        appDatabase.noteDAO().insert(note)
    }

    override fun getAll(): MutableLiveData<List<NoteModel>> {
        val mutableLiveData = MutableLiveData<List<NoteModel>>().apply { value = emptyList() }
        appDatabase.noteDAO().getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ notesList ->
                mutableLiveData.value = transform(notesList)
                Log.d(TAG, "getAll(): ${notesList.size}")
            }, { t: Throwable? -> t?.printStackTrace() })
        return mutableLiveData
    }

    private fun transform(notes: List<NoteEntity>) = mutableListOf<NoteModel>().apply {
        notes.forEach { add(NoteModel(it.title, it.text, it.thumbnail, it.id!!)) }
    }
}


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

class NoteRepositoryImpl() : NoteRepository {

    @Inject
    lateinit var appDatabase: AppDatabase

    @Inject
    lateinit var context: Context

    init {
        App.applicationComponent.inject(this)
    }

    override fun getById(id: String): MutableLiveData<NoteModel> {
        val mutableLiveData = MutableLiveData<NoteModel>()

        appDatabase.noteDAO().getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ note ->
                mutableLiveData.value = NoteModel.ModelMapper.entityToModel(note)
            }, { t: Throwable? -> t?.printStackTrace() })
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
                mutableLiveData.value = NoteModel.ModelMapper.entityToModelList(notesList)
                Log.d(TAG, "getAll(): ${notesList.size}")
            }, { t: Throwable? -> t?.printStackTrace() })
        return mutableLiveData
    }
}


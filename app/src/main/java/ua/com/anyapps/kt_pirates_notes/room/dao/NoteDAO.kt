package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.com.anyapps.kt_pirates_notes.model.Note

@Dao
interface NoteDAO {
    @Query("SELECT * FROM ${Note.TABLE_NAME} WHERE id = :id")
    fun getById(id: String): LiveData<Note>

    @Query("SELECT * FROM ${Note.TABLE_NAME} ORDER BY id DESC")
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)
}
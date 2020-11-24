package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.com.anyapps.kt_pirates_notes.model.Note

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: String?): LiveData<Note>

    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Delete
    fun delete(model: Note)
}
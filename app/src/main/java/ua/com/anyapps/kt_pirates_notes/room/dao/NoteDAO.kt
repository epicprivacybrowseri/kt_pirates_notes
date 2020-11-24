package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.com.anyapps.kt_pirates_notes.model.Noote

interface NoteDAO {
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: String?): LiveData<Noote>

    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Noote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noote: Noote)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(noote: Noote)

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Delete
    fun delete(model: Noote)
}
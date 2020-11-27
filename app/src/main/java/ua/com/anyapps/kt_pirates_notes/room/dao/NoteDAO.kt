package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.com.anyapps.kt_pirates_notes.model.ENote

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: String): LiveData<ENote>

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): LiveData<List<ENote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: ENote)

    /*@Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: ENote)

    @Query("DELETE FROM notes")
    fun deleteAll()

    @Delete
    fun delete(model: ENote)*/
}
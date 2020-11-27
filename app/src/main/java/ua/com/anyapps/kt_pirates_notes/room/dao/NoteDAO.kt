package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ua.com.anyapps.kt_pirates_notes.model.Note

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getById(id: String): LiveData<Note>

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)







    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll2(): List<Note>
}
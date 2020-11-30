package ua.com.anyapps.kt_pirates_notes.room.dao

import androidx.room.*
import io.reactivex.Flowable
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity

@Dao
interface NoteDAO {
    @Query("SELECT * FROM ${NoteEntity.TABLE_NAME} WHERE id = :id")
    fun getById(id: String): Flowable<NoteEntity>

    @Query("SELECT * FROM ${NoteEntity.TABLE_NAME} ORDER BY id DESC")
    fun getAllNotes(): Flowable<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteEntity: NoteEntity)
}
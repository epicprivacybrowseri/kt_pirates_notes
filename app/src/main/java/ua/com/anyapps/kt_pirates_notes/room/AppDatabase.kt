package ua.com.anyapps.kt_pirates_notes.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO

    companion object {
        const val DB_NAME = "database"
    }
}
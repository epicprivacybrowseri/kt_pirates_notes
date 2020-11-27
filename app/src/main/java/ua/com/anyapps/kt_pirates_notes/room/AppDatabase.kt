package ua.com.anyapps.kt_pirates_notes.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}
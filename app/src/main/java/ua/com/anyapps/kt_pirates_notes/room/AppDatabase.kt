package ua.com.anyapps.kt_pirates_notes.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ua.com.anyapps.kt_pirates_notes.room.dao.NoteDAO
import ua.com.anyapps.kt_pirates_notes.model.Noote

@Database(entities = [Noote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}
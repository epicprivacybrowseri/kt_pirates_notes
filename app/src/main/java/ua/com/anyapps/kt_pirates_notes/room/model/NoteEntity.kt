package ua.com.anyapps.kt_pirates_notes.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = NoteEntity.TABLE_NAME)
data class NoteEntity(
    val title: String,
    val text: String,
    val thumbnail: String = "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note",
    @PrimaryKey(autoGenerate = false) val id: Int? = null
) {
    companion object {
        const val TABLE_NAME = "notes"
    }
}
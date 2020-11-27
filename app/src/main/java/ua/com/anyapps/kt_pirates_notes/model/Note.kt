package ua.com.anyapps.kt_pirates_notes.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Note.TABLE_NAME)
data class Note(
    val title: String,
    val text: String,
    val thumbnail: String?="android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note",
    @PrimaryKey(autoGenerate = false) val id: Int? = null)
{
    companion object{
    const val TABLE_NAME = "notes"
}}
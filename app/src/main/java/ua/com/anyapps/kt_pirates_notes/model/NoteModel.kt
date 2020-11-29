package ua.com.anyapps.kt_pirates_notes.model

import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import java.io.Serializable

data class NoteModel(
        val title: String,
        val text: String,
        val thumbnail: String,
        val id: Int)
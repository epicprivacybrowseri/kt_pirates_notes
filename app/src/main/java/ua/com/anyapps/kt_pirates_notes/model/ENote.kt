package ua.com.anyapps.kt_pirates_notes.model

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class ENote(
    val title: String,
    val text: String,
    @PrimaryKey(autoGenerate = false) val id: Int? = null)
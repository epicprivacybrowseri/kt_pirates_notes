package ua.com.anyapps.kt_pirates_notes.model

import android.net.Uri

data class Note(var noteTitle:String, var noteText: String, var thumbnail: Uri = Uri.parse("android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note")) {
}
package ua.com.anyapps.kt_pirates_notes.model

import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity

data class NoteModel(
    val title: String,
    val text: String,
    val thumbnail: String,
    val id: Int
){
    object ModelMapper {
        fun from(source: NoteEntity) =
            NoteModel(source.title, source.text, source.thumbnail, source.id!!)

        fun fromList(source: List<NoteEntity>)= mutableListOf<NoteModel>().apply {
            source.forEach {
                add(NoteModel(it.title, it.text, it.thumbnail, it.id!!))
            }
        }
    }
}
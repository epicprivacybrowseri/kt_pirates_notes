package ua.com.anyapps.kt_pirates_notes.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.com.anyapps.kt_pirates_notes.model.NoteModel

@Entity(tableName = NoteEntity.TABLE_NAME)
data class NoteEntity(
    val title: String,
    val text: String,
    val thumbnail: String = "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note",
    @PrimaryKey(autoGenerate = false) val id: Int? = null
){
    object ModelMapper {
        fun modelToEntity(source: NoteModel) =
            NoteEntity(source.title, source.text, source.thumbnail, source.id)

        fun listOfModelToEntityList(source: List<NoteModel>)= mutableListOf<NoteEntity>().apply {
            source.forEach {
                add(NoteEntity(it.title, it.text, it.thumbnail, it.id))
            }
        }
    }

    companion object {
        const val TABLE_NAME = "notes"
    }
}
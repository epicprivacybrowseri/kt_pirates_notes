package ua.com.anyapps.kt_pirates_notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.notes_list_item.view.*
import ua.com.anyapps.kt_pirates_notes.R
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.ui.fragments.CellClickListener

class ListOfNotesAdapter(private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<ListOfNotesAdapter.ViewHolder>() {

    private var itemList: List<NoteModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(itemList[position])
        viewHolder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(itemList[position].id!!)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setList(data: List<NoteModel>){
        //itemList = data
        val notesList: List<NoteModel> = arrayListOf(
                NoteModel("t1", "t1", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 1),
                NoteModel("t2", "t2", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 2),
                NoteModel("t3", "t3", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 3),
                NoteModel("t4", "t4", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 4),
                NoteModel("t5", "t5", "android.resource://ua.com.anyapps.kt_pirates_notes/drawable/im_note", 5)
        )
        itemList = notesList
        notifyDataSetChanged()
    }

    /*fun update(data: List<Note>) {
        itemList = data
        notifyDataSetChanged()
    }*/

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.tvTitle
        private val tvText: TextView = view.tvText
        private val ivThumbnail: ImageView = view.ivThumbnail
        fun bind(note: NoteModel) {
            tvTitle.text = note.title.capitalize()
            tvText.text = note.text.capitalize()
            Glide.with(ivThumbnail.context).load(note.thumbnail).into(ivThumbnail)
        }
    }
}
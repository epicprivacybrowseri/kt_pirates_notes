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
import ua.com.anyapps.kt_pirates_notes.model.ENote
import ua.com.anyapps.kt_pirates_notes.view.fragments.CellClickListener

class ListOfNotesAdapter(var itemList: List<ENote>, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<ListOfNotesAdapter.ViewHolder>() {
    val TAG: String = "debapp"

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notes_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(itemList[position])
        viewHolder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun update(data: List<ENote>) {
        itemList = data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle: TextView = view.tvTitle
        private val tvText: TextView = view.tvText
        private val ivThumbnail: ImageView = view.ivThumbnail
        fun bind(note: ENote) {
            tvTitle.text = note.title.capitalize()
            tvText.text = note.text.capitalize()
            Glide.with(ivThumbnail.context).load(note.thumbnail).into(ivThumbnail)
        }
    }
}
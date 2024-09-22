package com.example.bertholat_laruelle_goichot_projet_note.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bertholat_laruelle_goichot_projet_note.R
import com.example.bertholat_laruelle_goichot_projet_note.model.Note

class NoteAdapter(
    private val updateNote: (Note) -> Unit,
    private val deleteNote: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var notes = emptyList<Note>()

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.noteTitle)
        val text: TextView = itemView.findViewById(R.id.noteText)
        val updateButton: Button = itemView.findViewById(R.id.button_update)
        val deleteButton: Button  = itemView.findViewById(R.id.button_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notes[position]
        holder.title.text = currentNote.title
        holder.text.text = currentNote.text

        // Configurer les actions de mise à jour et de suppression
        holder.updateButton.setOnClickListener {
            updateNote.invoke(currentNote)
        }

        holder.deleteButton.setOnClickListener {
            deleteNote.invoke(currentNote)
        }
    }

    override fun getItemCount() = notes.size

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}


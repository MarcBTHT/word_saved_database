package com.example.bertholat_laruelle_goichot_projet_note

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bertholat_laruelle_goichot_projet_note.model.Note
import com.example.bertholat_laruelle_goichot_projet_note.viewmodel.NoteViewModel

class UpdateNoteActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private var noteId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)

        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextText = findViewById<EditText>(R.id.editTextText)
        val buttonUpdate = findViewById<Button>(R.id.button_update)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        // Récupère les données passées par l'intention
        noteId = intent.getIntExtra("note_id", 0)
        val title = intent.getStringExtra("note_title")
        val text = intent.getStringExtra("note_text")

        editTextTitle.setText(title)
        editTextText.setText(text)

        buttonUpdate.setOnClickListener {
            val updatedTitle = editTextTitle.text.toString()
            val updatedText = editTextText.text.toString()

            // Met à jour la note
            val updatedNote = Note(noteId, updatedTitle, updatedText)
            noteViewModel.update(updatedNote)

            finish()
        }
    }
}

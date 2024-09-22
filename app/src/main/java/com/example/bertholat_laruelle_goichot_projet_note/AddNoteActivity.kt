package com.example.bertholat_laruelle_goichot_projet_note

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bertholat_laruelle_goichot_projet_note.model.Note
import com.example.bertholat_laruelle_goichot_projet_note.viewmodel.NoteViewModel

class AddNoteActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextText = findViewById<EditText>(R.id.editTextText)
        val buttonSave = findViewById<Button>(R.id.button_save)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        buttonSave.setOnClickListener {
            val title = editTextTitle.text.toString()
            val text = editTextText.text.toString()

            // Crée une nouvelle note et l'ajoute à la base de données
            val note = Note(0, title, text)
            noteViewModel.insert(note)

            // Ferme l'activité après avoir enregistré la note
            finish()
        }
    }
}

package com.example.bertholat_laruelle_goichot_projet_note

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bertholat_laruelle_goichot_projet_note.adapter.NoteAdapter
import com.example.bertholat_laruelle_goichot_projet_note.databinding.ActivityMainBinding
import com.example.bertholat_laruelle_goichot_projet_note.model.Note
import com.example.bertholat_laruelle_goichot_projet_note.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = NoteAdapter({ note -> updateNote(note) }, { note -> deleteNote(note) })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configure le ViewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        noteViewModel.allNotes.observe(this, { notes ->
            notes?.let { adapter.setNotes(it) }
        })

        // Configure le bouton classique pour ajouter une note
        val buttonAddNote = findViewById<Button>(R.id.button_add_note)
        buttonAddNote.setOnClickListener {
            val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateNote(note: Note) {
        val intent = Intent(this@MainActivity, UpdateNoteActivity::class.java)
        intent.putExtra("note_id", note.id)
        intent.putExtra("note_title", note.title)
        intent.putExtra("note_text", note.text)
        startActivity(intent)
    }

    private fun deleteNote(note: Note) {
        noteViewModel.delete(note)
    }
}


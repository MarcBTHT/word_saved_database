package com.example.bertholat_laruelle_goichot_projet_note.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.bertholat_laruelle_goichot_projet_note.data.db.NoteDatabase
import com.example.bertholat_laruelle_goichot_projet_note.data.db.NoteRepository
import com.example.bertholat_laruelle_goichot_projet_note.model.Note
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        allNotes = repository.allNotes // Ici on récupère la liste des notes
    }

    fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }
    // Pour supprimer une note
    fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }
    // Methode pour mettre à jour une note existante
    fun update(note: Note) = viewModelScope.launch {
        repository.update(note)
    }
}

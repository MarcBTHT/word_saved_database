package com.example.bertholat_laruelle_goichot_projet_note.data.db

import androidx.lifecycle.LiveData
import com.example.bertholat_laruelle_goichot_projet_note.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    // Variable pour obtenir toutes les notes en LiveData
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    // Fonction d'insertion de note
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }
    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
    suspend fun update(note: Note) {
        noteDao.update(note)
    }
}

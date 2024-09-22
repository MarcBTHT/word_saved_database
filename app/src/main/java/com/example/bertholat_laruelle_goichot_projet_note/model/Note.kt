package com.example.bertholat_laruelle_goichot_projet_note.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    @ColumnInfo(name = "note")
    val text: String
)
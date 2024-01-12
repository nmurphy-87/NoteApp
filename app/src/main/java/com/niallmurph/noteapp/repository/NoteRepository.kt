package com.niallmurph.noteapp.repository

import com.niallmurph.noteapp.data.NoteDatabaseDao
import com.niallmurph.noteapp.model.Note
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

class NoteRepository @Inject constructor(private val noteDatabaseDao : NoteDatabaseDao) {

    suspend fun addNote(note : Note) = noteDatabaseDao.insert(note)

    suspend fun updateNote(note : Note) = noteDatabaseDao.update(note)

    suspend fun deleteNote(note : Note) = noteDatabaseDao.deleteNote(note)

    suspend fun deleteAllNotes() = noteDatabaseDao.deleteAllEntries()

    fun getAllNotes() : Flow<List<Note>> = noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()

    suspend fun getNoteById(id : String) = noteDatabaseDao.getNoteById(id)

}
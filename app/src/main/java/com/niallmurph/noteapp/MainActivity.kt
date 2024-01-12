package com.niallmurph.noteapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.niallmurph.noteapp.data.Note
import com.niallmurph.noteapp.data.NotesDataSource
import com.niallmurph.noteapp.screens.NoteScreen
import com.niallmurph.noteapp.screens.NoteViewModel
import com.niallmurph.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val noteViewModel : NoteViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesApp(noteViewModel: NoteViewModel = viewModel()){
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(
        notes = notesList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.removeNote(it) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {
    }
}
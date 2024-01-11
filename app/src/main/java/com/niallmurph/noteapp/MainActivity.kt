package com.niallmurph.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.niallmurph.noteapp.data.NotesDataSource
import com.niallmurph.noteapp.screens.NoteScreen
import com.niallmurph.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                NoteScreen(
                    notes = NotesDataSource().loadNotes(),
                    onAddNote = {},
                    onRemoveNote = {}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {
    }
}
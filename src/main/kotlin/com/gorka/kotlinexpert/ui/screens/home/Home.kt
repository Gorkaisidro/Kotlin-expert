package com.gorka.kotlinexpert.ui.screens.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gorka.kotlinexpert.data.Note

@Composable
@Preview
fun Home(vm: HomeViewModel, onNoteClick: (noteId: Long) -> Unit) {

    // Comienza la composición de la interfaz de usuario utilizando el MaterialTheme
    MaterialTheme {
        Scaffold(
            topBar = { TopBar(vm::onFilterClick) },
            floatingActionButton = {
                FloatingActionButton(onClick = { onNoteClick(Note.NEW_NOTE) }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Note")
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                if (vm.state.loading) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        vm.state.filterNotes?.let { note ->
                            NotesList(
                                notes = note,
                                onNoteClick = { onNoteClick(it.id) }
                            )
                        }
                    }
                }
            }
        }
    }


}



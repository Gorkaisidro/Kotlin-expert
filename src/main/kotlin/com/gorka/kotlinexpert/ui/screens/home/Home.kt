package com.gorka.kotlinexpert.ui.screens.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
@Preview
fun Home() = with(HomeState) {
    val state by state.collectAsState()

    LaunchedEffect(true) {
        loadNotes(this)
    }

    // Comienza la composición de la interfaz de usuario utilizando el MaterialTheme
    MaterialTheme {
        Scaffold(topBar = { TopBar(::onFilterClick) }) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                if (state.loading) {
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
                        state.filterNotes?.let {
                            NotesList(it)
                        }
                    }
                }
            }
        }
    }


}



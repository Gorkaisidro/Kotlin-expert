package com.gorka.kotlinexpert.ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.gorka.kotlinexpert.data.Filter
import com.gorka.kotlinexpert.data.Note

@Composable
fun TopBar(onFilterClick: (Filter) -> Unit) {
    TopAppBar(
        title = { Text("My Notes") },
        actions = { FiltersAction(onFilterClick) }
    )
}

@Composable
private fun FiltersAction(onFilterClick: (Filter) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    @Composable
    infix fun Filter.ToMenuItem(label: String) {
        DropdownMenuItem(onClick = {
            onFilterClick(this)
            expanded = false
        }) {
            Text(label)
        }
    }


    IconButton(onClick = { expanded = true }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Filter.All ToMenuItem "All"
            Filter.ByType(Note.Type.TEXT) ToMenuItem "Text"
            Filter.ByType(Note.Type.AUDIO) ToMenuItem "Audio"
        }
    }
}
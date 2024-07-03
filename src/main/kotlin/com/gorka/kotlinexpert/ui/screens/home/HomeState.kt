package com.gorka.kotlinexpert.ui.screens.home

import com.gorka.kotlinexpert.data.Filter
import com.gorka.kotlinexpert.data.Note
import com.gorka.kotlinexpert.data.getNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

object HomeState {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState (loading = true)

            getNotes().collect {
                _state.value = UiState(notes = it)
            }
        }
    }

    fun onFilterClick(filter: Filter) {
        _state.update { it.copy(filter = filter) }
    }

    data class UiState(
        var notes: List<Note>? = null,
        val loading: Boolean = false,
        val filter: Filter = Filter.All
    ) {
        val filterNotes: List<Note>?
            get() = when(filter) {
                Filter.All -> notes
                is Filter.ByType -> notes?.filter { it.type == filter.type }
        }
    }
}
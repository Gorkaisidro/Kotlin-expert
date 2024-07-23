package com.gorka.kotlinexpert.ui.screens.home

import com.gorka.kotlinexpert.data.Filter
import com.gorka.kotlinexpert.data.Note
import com.gorka.kotlinexpert.data.remote.notesClient
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

operator fun <T> StateFlow<T>.getValue(owner: Any?, property: KProperty<*>): T = this.value
operator fun <T> MutableStateFlow<T>.setValue(owner: Any?, property: KProperty<*>, newValue: T) {
    this.value = newValue
}

object HomeState {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState(loading = true)
            val response = notesClient.request("http://127.0.0.1:8080/notes")
            _state.value = UiState(notes = response.body())
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
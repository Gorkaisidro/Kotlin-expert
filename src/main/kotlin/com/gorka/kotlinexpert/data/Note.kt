package com.gorka.kotlinexpert.data

import com.gorka.kotlinexpert.data.Note.Type
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow


data class Note (
    val title: String,
    val description: String,
    val type: Type) {
    enum class Type { TEXT, AUDIO }
    companion object
}

val Note.Companion.fakeNotes get() = flow {
    delay(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXT
        )
    }
    emit(notes)
}

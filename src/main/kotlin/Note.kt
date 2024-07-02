import Note.Type
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

data class Note (
    val title: String,
    val description: String,
    val type: Type) {
    enum class Type { TEXTO, AUDIO }
}

fun getNotes(): Flow<List<Note>> = flow {
    delay(2000)
    var notes = emptyList<Note>()
    (1..10).forEach() {
        notes = notes + Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXTO
        )
        emit(notes)
        delay(500)
    }
}

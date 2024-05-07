import Note.Type
import kotlin.concurrent.thread

data class Note (
    val title: String,
    val description: String,
    val type: Type) {
    enum class Type { TEXTO, AUDIO }
}

fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXTO
        )
    }
    callback(notes)
}

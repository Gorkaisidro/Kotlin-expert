import Note.Type
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

data class Note (
    val title: String,
    val description: String,
    val type: Type) {
    enum class Type { TEXTO, AUDIO }
}

suspend fun getNotes() = withContext(Dispatchers.IO) {
    delay(2000)
    (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Type.AUDIO else Type.TEXTO
        )
    }
}

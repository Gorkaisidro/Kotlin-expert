import com.gorka.kotlinexpert.data.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ViewModel {
    private val _state: MutableStateFlow<Note> = MutableStateFlow(Note("Title 1", "Description 2", Note.Type.TEXTO))
    val state: StateFlow<Note> = _state.asStateFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.value = Note("Title $count", "Description $count", Note.Type.TEXTO)
        }
    }
}


fun main(): Unit = runBlocking {
    val viewModel = ViewModel()
    launch {
        viewModel.update()
    }
    viewModel.state.collect(::println)
}
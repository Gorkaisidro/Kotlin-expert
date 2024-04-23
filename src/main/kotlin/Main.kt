import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.jvm.internal.Ref.BooleanRef

class AppState {
    // Definición de un estado mutable llamado "text" que almacenará el contenido del TextField
    val text = mutableStateOf("")
    // Determinación si el botón estará habilitado o no según si hay texto ingresado en el TextField
    val buttonEnabled: Boolean
        get() = text.value.isNotEmpty()
}

@Composable
@Preview
fun App(appState : AppState) {

    // Comienza la composición de la interfaz de usuario utilizando el MaterialTheme
    MaterialTheme {
        // Columna que organiza los elementos verticalmente
        Column {
            // Entrada de texto donde el usuario puede ingresar su texto
            TextField(value = appState.text.value, onValueChange = { newText -> appState.text.value = newText })
            // Texto que muestra el mensaje construido
            Text(text = buildMessage(appState.text.value))
            // Botón para limpiar el texto del TextField
            Button(onClick = { appState.text.value = "" }, enabled = appState.buttonEnabled) {
                Text("Clean")
            }
        }
    }
}

fun buildMessage(message: String) : String = "Hello $message"

fun main() {
    val appState = AppState()
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(appState)
        }
    }
}

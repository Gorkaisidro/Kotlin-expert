package com.gorka.kotlinexpert

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.gorka.kotlinexpert.ui.App


fun main() {
    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}

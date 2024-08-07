import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

group = "com.gorka"
version = "1.0-SNAPSHOT"

allprojects{
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

plugins {
    kotlin("jvm") apply false
    kotlin("plugin.serialization") apply false
    id("org.jetbrains.compose") apply false
}



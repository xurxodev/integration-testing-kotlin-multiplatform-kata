package com.xurxodev.integrationtesting.common

internal actual class FileReader {
    internal actual fun readFile(file: String): String {
        return javaClass.classLoader.getResource(file).readText()
    }
}

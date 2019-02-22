package com.xurxodev.integrationtesting.common

internal expect class FileReader() {
    internal fun readFile(file: String): String
}

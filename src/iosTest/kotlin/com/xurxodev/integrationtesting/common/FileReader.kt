package com.xurxodev.integrationtesting.common

import kotlinx.cinterop.refTo
import kotlinx.cinterop.toKString
import platform.posix.fclose
import platform.posix.fgets
import platform.posix.fopen

internal actual class FileReader {
    internal actual fun readFile(file: String): String {
        var fileName = getFixedPath(file)

        val file = fopen(fileName, "r") ?: error("Cannot read file '$fileName'")
        var buffer = ByteArray(1024)
        var text = StringBuilder()
        try {
            while (true) {
                val nextLine =
                    fgets(buffer.refTo(0), buffer.size, file)?.toKString() ?: break
                text.append(nextLine)
            }
        } finally {
            fclose(file)
        }
        return text.toString()
    }

    fun getFixedPath(file: String): String {
        val path = "/Users/xurxodev/Workspace/xurxodev/Katas/Kotlin-Multiplatform/integration-testing-kotlin-multiplatform-kata/src/commonTest/resources/"

        return "$path$file"
    }
}

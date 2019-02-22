package com.xurxodev.integrationtesting.common.coroutines

import kotlinx.coroutines.runBlocking

internal actual fun <T> runTest(block: suspend () -> T): T {
    return runBlocking { block() }
}
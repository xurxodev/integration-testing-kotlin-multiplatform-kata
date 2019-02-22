package com.xurxodev.integrationtesting.common.coroutines

internal expect fun <T> runTest(block: suspend () -> T): T
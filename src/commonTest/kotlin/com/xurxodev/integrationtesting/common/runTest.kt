package com.xurxodev.integrationtesting.common

internal expect fun <T> runTest(block: suspend () -> T): T
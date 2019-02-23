package com.xurxodev.integrationtesting.error

sealed class ApiError
data class UnknownError(val code: Int) : ApiError()
object NetworkError : ApiError()
object ItemNotFoundError : ApiError()
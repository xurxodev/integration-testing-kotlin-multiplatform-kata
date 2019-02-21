package com.xurxodev.integrationtesting.error

sealed class ApiError
data class HttpError(val code: Int) : ApiError()
object NetworkError : ApiError()
object ItemNotFoundError : ApiError()
data class UnknownError(val exception: Exception) : ApiError()
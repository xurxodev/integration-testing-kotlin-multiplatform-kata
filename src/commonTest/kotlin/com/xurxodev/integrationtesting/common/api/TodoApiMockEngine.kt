package com.xurxodev.integrationtesting.common.api

import com.xurxodev.integrationtesting.common.FileReader
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockHttpRequest
import io.ktor.client.engine.mock.MockHttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import kotlinx.coroutines.io.ByteReadChannel
import kotlinx.io.charsets.Charsets
import kotlinx.io.core.toByteArray
import kotlin.test.assertEquals

class TodoApiMockEngine {
    lateinit var mockResponse: MockResponse
    var lastRequest: MockHttpRequest? = null

    fun enqueueMockResponse(
        endpointSegment: String,
        responseFile: String,
        httpStatusCode: Int = 200
    ) {
        val responseJson = FileReader().readFile(responseFile)

        mockResponse = MockResponse(endpointSegment, responseJson, httpStatusCode)
    }

    fun get() = MockEngine {
        lastRequest = this

        when (url.encodedPath) {
            "${mockResponse.endpointSegment}" -> {
                MockHttpResponse(
                    call,
                    HttpStatusCode.fromValue(mockResponse.httpStatusCode),
                    ByteReadChannel(mockResponse.responseBody.toByteArray(Charsets.UTF_8)),
                    headersOf(HttpHeaders.ContentType to listOf(ContentType.Application.Json.toString()))
                )
            }
            else -> {
                error("Unhandled ${url.fullPath}")
            }
        }
    }

    fun verifyRequestContainsHeader(key: String, expectedValue: String) {
        val value = lastRequest!!.headers[key]
        assertEquals(expectedValue, value)
    }
}
package com.xurxodev.integrationtesting

import com.xurxodev.integrationtesting.common.api.TodoApiMockEngine
import com.xurxodev.integrationtesting.common.coroutines.runTest
import com.xurxodev.integrationtesting.common.responses.getTasksResponse
import com.xurxodev.integrationtesting.model.Task
import todoapiclient.fold
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class TodoApiClientShould {
    companion object {
        private const val ALL_TASK_SEGMENT = "/todos"
    }

    private val todoApiMockEngine = TodoApiMockEngine()

    @Test
    fun `send accept header`() = runTest {
        val apiClient = givenAMockTodoApiClient(ALL_TASK_SEGMENT, getTasksResponse())

        apiClient.getAllTasks()

        todoApiMockEngine.verifyRequestContainsHeader("Accept", "application/json")
    }

    @Test
    fun `return tasks and parses it properly`() = runTest {
        val apiClient = givenAMockTodoApiClient(ALL_TASK_SEGMENT, getTasksResponse())

        val tasksResponse = apiClient.getAllTasks()

        assertTrue(tasksResponse.isRight)

        tasksResponse.fold(
            { fail() },
            { right ->
                assertEquals(4, right.size.toLong())
                assertTaskContainsExpectedValues(right[0])
            })
    }

    private fun assertTaskContainsExpectedValues(task: Task?) {
        assertTrue(task != null)
        assertEquals(task.id, 1)
        assertEquals(task.userId, 1)
        assertEquals(task.title, "delectus aut autem")
        assertFalse(task.completed)
    }

    private fun givenAMockTodoApiClient(
        endpointSegment: String,
        responseBody: String,
        httpStatusCode: Int = 200
    ): TodoApiClient {
        todoApiMockEngine.enqueueMockResponse(endpointSegment, responseBody, httpStatusCode)

        return TodoApiClient(todoApiMockEngine.get())
    }
}
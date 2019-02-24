package com.xurxodev.integrationtesting

import com.xurxodev.integrationtesting.common.api.TodoApiMockEngine
import com.xurxodev.integrationtesting.common.coroutines.runTest
import com.xurxodev.integrationtesting.common.responses.addTaskRequest
import com.xurxodev.integrationtesting.common.responses.addTaskResponse
import com.xurxodev.integrationtesting.common.responses.getTaskByIdResponse
import com.xurxodev.integrationtesting.common.responses.getTasksResponse
import com.xurxodev.integrationtesting.common.responses.updateTaskRequest
import com.xurxodev.integrationtesting.common.responses.updateTaskResponse
import com.xurxodev.integrationtesting.error.UnknownError
import com.xurxodev.integrationtesting.error.ItemNotFoundError
import com.xurxodev.integrationtesting.model.Task
import todoapiclient.fold
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

class TodoApiClientShould {
    companion object {
        private const val ANY_TASK_ID = "1"

        private const val ALL_TASK_SEGMENT = "/todos"
        private const val TASK_SEGMENT = "/todos/$ANY_TASK_ID"

        private val ANY_TASK = Task(1, 1, "delectus aut autem", false)
    }

    private val todoApiMockEngine = TodoApiMockEngine()

    @Test
    fun `send accept header`() = runTest {
        val apiClient = givenAMockTodoApiClient(ALL_TASK_SEGMENT, getTasksResponse())

        apiClient.getAllTasks()

        todoApiMockEngine.verifyRequestContainsHeader("Accept", "application/json")
    }

    @Test
    fun `send request with get http verb getting all task`() = runTest {
        val apiClient = givenAMockTodoApiClient(ALL_TASK_SEGMENT, getTasksResponse())

        apiClient.getAllTasks()

        todoApiMockEngine.verifyGetRequest()
    }

    @Test
    fun `return tasks and parses it properly`() = runTest {
        val apiClient = givenAMockTodoApiClient(ALL_TASK_SEGMENT, getTasksResponse())

        val tasksResponse = apiClient.getAllTasks()

        tasksResponse.fold(
            { left -> fail("Should return right but was left: $left") },
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
        responseBody: String = "",
        httpStatusCode: Int = 200
    ): TodoApiClient {
        todoApiMockEngine.enqueueMockResponse(endpointSegment, responseBody, httpStatusCode)

        return TodoApiClient(todoApiMockEngine.get())
    }
}
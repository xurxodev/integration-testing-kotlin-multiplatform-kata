package com.xurxodev.integrationtesting.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)

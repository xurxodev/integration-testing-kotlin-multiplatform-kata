package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    @SerialName("id") val id: String,
    @SerialName("userId") val userId: String,
    @SerialName("title") val title: String,
    @SerialName("finished") val isFinished: Boolean
)

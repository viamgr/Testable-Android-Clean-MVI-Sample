package com.cleansample.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributeResponse(
    @SerialName("label")
    val label: String,
    @SerialName("unit")
    val unit: String? = null,
    @SerialName("value")
    val value: String,
)
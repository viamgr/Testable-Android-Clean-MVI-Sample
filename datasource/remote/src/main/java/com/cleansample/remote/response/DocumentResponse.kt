package com.cleansample.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DocumentResponse(
    @SerialName("link")
    val link: String,
    @SerialName("title")
    val title: String,
)
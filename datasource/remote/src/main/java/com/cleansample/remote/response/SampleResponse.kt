package com.cleansample.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleResponse(
    @SerialName("address")
    val address: AddressResponse,
    @SerialName("attributes")
    val attributes: List<AttributeResponse>,
    @SerialName("description")
    val description: String,
    @SerialName("documents")
    val documents: List<DocumentResponse>,
    @SerialName("features")
    val features: List<String>,
    @SerialName("id")
    val id: String,
    @SerialName("pictures")
    val pictures: List<String>,
    @SerialName("posted-date-time")
    val postedDateTime: String,
    @SerialName("price")
    val price: PriceResponse,
    @SerialName("title")
    val title: String,
    @SerialName("visits")
    val visits: Int,
)
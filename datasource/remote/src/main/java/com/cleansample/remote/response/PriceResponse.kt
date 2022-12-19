package com.cleansample.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PriceResponse(
    @SerialName("amount")
    val amount: Double,
    @SerialName("currency")
    val currency: String,
)
package com.cleansample.domain.entity

data class SampleEntity(
    val address: AddressEntity,
    val attributes: List<AttributeEntity>,
    val description: String,
    val documents: List<DocumentEntity>,
    val features: List<String>,
    val id: String,
    val pictures: List<String>,
    val postedDateTime: String,
    val price: PriceEntity,
    val title: String,
    val visits: Int,
)
package com.cleansample.data.datasource.model

data class SampleModel(
    val address: AddressModel,
    val attributes: List<AttributeModel>,
    val description: String,
    val documents: List<DocumentModel>,
    val features: List<String>,
    val id: String,
    val pictures: List<String>,
    val postedDateTime: String,
    val price: PriceModel,
    val title: String,
    val visits: Int,
)
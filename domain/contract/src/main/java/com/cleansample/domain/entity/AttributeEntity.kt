package com.cleansample.domain.entity

data class AttributeEntity(
    val label: String,
    val unit: String? = null,
    val value: String,
)
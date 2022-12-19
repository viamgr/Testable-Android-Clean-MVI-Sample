package com.cleansample.use_case.model

data class Attribute(
    val label: String,
    val unit: String? = null,
    val value: String,
)
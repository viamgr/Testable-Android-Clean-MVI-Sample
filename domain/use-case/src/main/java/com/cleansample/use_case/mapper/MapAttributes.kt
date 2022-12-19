package com.cleansample.use_case.mapper

import com.cleansample.domain.entity.AttributeEntity
import com.cleansample.use_case.model.Attribute

internal fun List<AttributeEntity>.mapAttributes() = map { Attribute(it.label, it.unit, it.value) }
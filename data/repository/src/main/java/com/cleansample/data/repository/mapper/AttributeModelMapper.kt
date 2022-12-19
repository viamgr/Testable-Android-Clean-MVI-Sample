package com.cleansample.data.repository.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.AttributeModel
import com.cleansample.domain.entity.AttributeEntity
import javax.inject.Inject

internal class AttributeModelMapper @Inject constructor() :
    Mapper<AttributeModel, AttributeEntity> {
    override fun map(type: AttributeModel): AttributeEntity {
        return AttributeEntity(
            label = type.label,
            unit = type.unit,
            value = type.value
        )
    }
}
package com.cleansample.remote.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.AttributeModel
import com.cleansample.remote.response.AttributeResponse
import javax.inject.Inject

internal class AttributeResponseMapper @Inject constructor() :
    Mapper<AttributeResponse, AttributeModel> {
    override fun map(type: AttributeResponse): AttributeModel {
        return AttributeModel(
            label = type.label,
            unit = type.unit,
            value = type.value
        )
    }
}
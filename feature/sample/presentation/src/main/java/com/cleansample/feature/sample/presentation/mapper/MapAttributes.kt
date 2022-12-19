package com.cleansample.feature.sample.presentation.mapper

import com.cleansample.feature.sample.presentation.model.Attribute
import com.cleansample.use_case.samples.GetSampleDetailUseCase

internal fun GetSampleDetailUseCase.Response.mapAttributes() =
    attributes.map {
        Attribute(
            label = it.label,
            value = it.value,
            unit = it.unit
        )
    }
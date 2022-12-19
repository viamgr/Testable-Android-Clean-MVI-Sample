package com.cleansample.feature.sample.presentation.mapper

import com.cleansample.feature.sample.presentation.IMAGE_SIZE_KEY
import com.cleansample.feature.sample.presentation.IMAGE_SIZE_MEDIUM
import com.cleansample.use_case.samples.GetSampleDetailUseCase

internal fun GetSampleDetailUseCase.Response.mapPictures() =
    pictures.map {
        it.replace(IMAGE_SIZE_KEY, IMAGE_SIZE_MEDIUM)
    }
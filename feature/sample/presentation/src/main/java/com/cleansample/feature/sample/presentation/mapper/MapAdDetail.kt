package com.cleansample.feature.sample.presentation.mapper

import com.cleansample.feature.sample.presentation.detail.SampleDetailState
import com.cleansample.use_case.samples.GetSampleDetailUseCase

internal fun GetSampleDetailUseCase.Response.mapAdDetail(
    state: SampleDetailState,
) = state.copy(
    error = null,
    isLoading = false,
    description = description,
    features = mapFeatures(),
    pictures = mapPictures(),
    documents = mapDocuments(),
    summary = mapSummary(),
    attributes = mapAttributes()
)
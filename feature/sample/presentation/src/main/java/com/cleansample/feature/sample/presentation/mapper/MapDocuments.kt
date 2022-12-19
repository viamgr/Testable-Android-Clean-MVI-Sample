package com.cleansample.feature.sample.presentation.mapper

import com.cleansample.feature.sample.presentation.model.Document
import com.cleansample.use_case.samples.GetSampleDetailUseCase

internal fun GetSampleDetailUseCase.Response.mapDocuments() =
    documents.map {
        Document(
            link = it.link,
            title = it.title
        )
    }
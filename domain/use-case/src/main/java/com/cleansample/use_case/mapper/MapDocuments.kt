package com.cleansample.use_case.mapper

import com.cleansample.domain.entity.DocumentEntity
import com.cleansample.use_case.model.Document

internal fun List<DocumentEntity>.mapDocuments() =
    map { Document(it.link, it.title) }
package com.cleansample.remote.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.DocumentModel
import com.cleansample.remote.response.DocumentResponse
import javax.inject.Inject

internal class DocumentResponseMapper @Inject constructor() :
    Mapper<DocumentResponse, DocumentModel> {
    override fun map(type: DocumentResponse): DocumentModel {
        return DocumentModel(
            link = type.link,
            title = type.title
        )
    }
}
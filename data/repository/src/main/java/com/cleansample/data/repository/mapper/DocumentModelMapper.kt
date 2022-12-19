package com.cleansample.data.repository.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.DocumentModel
import com.cleansample.domain.entity.DocumentEntity
import javax.inject.Inject

internal class DocumentModelMapper @Inject constructor() : Mapper<DocumentModel, DocumentEntity> {
    override fun map(type: DocumentModel): DocumentEntity {
        return DocumentEntity(
            link = type.link,
            title = type.title
        )
    }
}
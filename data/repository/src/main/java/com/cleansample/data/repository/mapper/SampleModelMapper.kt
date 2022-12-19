package com.cleansample.data.repository.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.SampleModel
import com.cleansample.domain.entity.SampleEntity
import javax.inject.Inject

internal class SampleModelMapper @Inject constructor(
    private val addressModelMapper: AddressModelMapper,
    private val documentModelMapper: DocumentModelMapper,
    private val attributeModelMapper: AttributeModelMapper,
    private val priceModelMapper: PriceModelMapper,
) : Mapper<SampleModel, SampleEntity> {
    override fun map(type: SampleModel): SampleEntity {
        return SampleEntity(
            description = type.description,
            postedDateTime = type.postedDateTime,
            id = type.id,
            title = type.title,
            visits = type.visits,
            features = type.features,
            pictures = type.pictures,
            attributes = type.attributes.map(attributeModelMapper::map),
            address = addressModelMapper.map(type.address),
            price = priceModelMapper.map(type.price),
            documents = type.documents.map(documentModelMapper::map),
        )
    }
}
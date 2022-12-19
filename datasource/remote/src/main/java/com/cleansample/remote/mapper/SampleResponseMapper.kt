package com.cleansample.remote.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.SampleModel
import com.cleansample.remote.response.SampleResponse
import javax.inject.Inject

internal class SampleResponseMapper @Inject constructor(
    private val addressResponseMapper: AddressResponseMapper,
    private val documentResponseMapper: DocumentResponseMapper,
    private val attributeResponseMapper: AttributeResponseMapper,
    private val priceResponseMapper: PriceResponseMapper,

    ) : Mapper<SampleResponse, SampleModel> {
    override fun map(type: SampleResponse): SampleModel {
        return SampleModel(
            description = type.description,
            postedDateTime = type.postedDateTime,
            id = type.id,
            title = type.title,
            visits = type.visits,
            features = type.features,
            pictures = type.pictures,
            attributes = type.attributes.map(attributeResponseMapper::map),
            address = addressResponseMapper.map(type.address),
            price = priceResponseMapper.map(type.price),
            documents = type.documents.map(documentResponseMapper::map),
        )
    }
}
package com.cleansample.data.repository.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.AddressModel
import com.cleansample.domain.entity.AddressEntity
import javax.inject.Inject

internal class AddressModelMapper @Inject constructor() : Mapper<AddressModel, AddressEntity> {
    override fun map(type: AddressModel): AddressEntity {
        return AddressEntity(
            city = type.city,
            latitude = type.latitude,
            longitude = type.longitude,
            street = type.street,
            zipCode = type.zipCode,
        )
    }
}
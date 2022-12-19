package com.cleansample.remote.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.AddressModel
import com.cleansample.remote.response.AddressResponse
import javax.inject.Inject

internal class AddressResponseMapper @Inject constructor() : Mapper<AddressResponse, AddressModel> {
    override fun map(type: AddressResponse): AddressModel {
        return AddressModel(
            city = type.city,
            latitude = type.latitude,
            longitude = type.longitude,
            street = type.street,
            zipCode = type.zipCode,
        )
    }
}
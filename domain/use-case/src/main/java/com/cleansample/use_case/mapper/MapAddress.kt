package com.cleansample.use_case.mapper

import com.cleansample.domain.entity.AddressEntity
import com.cleansample.use_case.model.Address

internal fun AddressEntity.mapAddress() = Address(
    city,
    latitude,
    longitude,
    street,
    zipCode
)
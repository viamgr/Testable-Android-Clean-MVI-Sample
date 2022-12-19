package com.cleansample.use_case.mapper

import com.cleansample.domain.entity.PriceEntity
import com.cleansample.use_case.model.Price

internal fun PriceEntity.mapPrice() = Price(
    amount = amount,
    currency = currency
)
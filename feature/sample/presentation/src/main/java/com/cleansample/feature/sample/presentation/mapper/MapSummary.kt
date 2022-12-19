package com.cleansample.feature.sample.presentation.mapper

import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.feature.sample.presentation.utils.formatPrice
import com.cleansample.use_case.samples.GetSampleDetailUseCase

internal fun GetSampleDetailUseCase.Response.mapSummary() = Summary(
    title = title,
    price = price.amount.formatPrice(),
    currency = price.currency,
    city = address.city,
    street = address.street,
    zipCode = address.zipCode,
    date = postedDateTime,
    visits = visits,
    id = id
)
package com.cleansample.remote.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.PriceModel
import com.cleansample.remote.response.PriceResponse
import javax.inject.Inject

internal class PriceResponseMapper @Inject constructor() : Mapper<PriceResponse, PriceModel> {
    override fun map(type: PriceResponse): PriceModel {
        return PriceModel(
            amount = type.amount,
            currency = type.currency
        )
    }
}
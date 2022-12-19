package com.cleansample.data.repository.mapper

import com.cleansample.core.mapper.Mapper
import com.cleansample.data.datasource.model.PriceModel
import com.cleansample.domain.entity.PriceEntity
import javax.inject.Inject

internal class PriceModelMapper @Inject constructor() : Mapper<PriceModel, PriceEntity> {
    override fun map(type: PriceModel): PriceEntity {
        return PriceEntity(
            amount = type.amount,
            currency = type.currency
        )
    }
}
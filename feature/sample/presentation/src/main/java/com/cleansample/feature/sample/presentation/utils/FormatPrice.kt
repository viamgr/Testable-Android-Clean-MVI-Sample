package com.cleansample.feature.sample.presentation.utils

import java.text.DecimalFormat

internal fun Double.formatPrice(): String {
    return DecimalFormat("0.###").format(this)
}
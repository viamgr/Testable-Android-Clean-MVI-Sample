package com.cleansample.ui_common.navigation

import androidx.annotation.StringRes

interface WithLabel {
    @StringRes
    fun getLabelResourceId(): Int = -1
}
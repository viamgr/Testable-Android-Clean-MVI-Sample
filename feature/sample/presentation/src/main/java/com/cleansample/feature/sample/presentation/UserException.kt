package com.cleansample.feature.sample.presentation

import androidx.annotation.StringRes

data class UserException(@StringRes val errorResourceId: Int) : Exception()
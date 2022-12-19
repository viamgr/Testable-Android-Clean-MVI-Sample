package com.cleansample.use_case.mapper

import java.time.LocalDate
import java.time.format.DateTimeFormatter

const val SERVER_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
const val USER_DATE_PATTERN = "MM.dd.yyyy"

internal fun String.mapDate(): String {
    val parse = LocalDate.parse(this, DateTimeFormatter.ofPattern(SERVER_DATE_PATTERN))
    return parse.format(DateTimeFormatter.ofPattern(USER_DATE_PATTERN))
}
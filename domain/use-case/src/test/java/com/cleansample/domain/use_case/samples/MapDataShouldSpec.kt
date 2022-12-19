package com.cleansample.domain.use_case.samples

import com.cleansample.use_case.mapper.mapDate
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import java.time.format.DateTimeParseException

internal class MapDataShouldSpec : ShouldSpec() {

    init {
        should("map date with valid data should works properly") {
            val asExpected = "10.08.2021"
            val input = "2021-10-08T08:01:00.000+0100"
            val mappedDate = input.mapDate()
            mappedDate shouldBe asExpected
        }

        should("map date with invalid month of year should throws exception") {
            val input = "2022-22-08T08:01:00.000+0100"
            shouldThrow<DateTimeParseException> {
                input.mapDate()
            }
        }
    }

}
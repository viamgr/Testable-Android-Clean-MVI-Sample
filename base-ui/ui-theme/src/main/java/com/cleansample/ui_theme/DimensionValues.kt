package com.cleansample.ui_theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class DimensionValues(
    val smallDividerHeight: Dp = 1.dp,
    val largeDividerHeight: Dp = 8.dp,
    val spaceLarge: Dp = 8.dp,
    val spaceMedium: Dp = 4.dp,
    val spaceSmall: Dp = 2.dp,
)
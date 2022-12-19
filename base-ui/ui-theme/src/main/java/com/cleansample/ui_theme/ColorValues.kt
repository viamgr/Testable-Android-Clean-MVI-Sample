package com.cleansample.ui_theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorValues(
    val info: Color = Color(0xFF797979),
    val divider: Color = info.copy(alpha = 0.2F),
    val primary: Color = Color(0xFF000000),
    val price: Color = Color(0xFF86B817),
)
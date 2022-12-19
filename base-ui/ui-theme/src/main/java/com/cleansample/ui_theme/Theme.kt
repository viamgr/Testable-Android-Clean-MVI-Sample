package com.cleansample.ui_theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppMaterialTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTypography provides typographyValues,
        LocalColorValues provides colorValues,
        LocalDimens provides dimensionValues
    ) {
        MaterialTheme(
            /* colors = ..., typography = ..., shapes = ... */
            content = content
        )
    }
}

object Theme {
    val dimensions: DimensionValues
        @Composable
        @ReadOnlyComposable
        get() = LocalDimens.current
    val colorScheme: ColorValues
        @Composable
        @ReadOnlyComposable
        get() = LocalColorValues.current
    val typography: TypographyValues
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}


val colorValues = ColorValues()
val dimensionValues = DimensionValues()
val typographyValues: TypographyValues
    @Composable
    get() = with(MaterialTheme.typography) {
        return TypographyValues(
            bodyMediumInfo = bodyMedium.copy(color = Theme.colorScheme.info),
            titleLarge = titleLarge.copy(color = Theme.colorScheme.primary),
            bodyMedium = bodyMedium.copy(color = Theme.colorScheme.primary),
            titleLargePrice = titleLarge.copy(color = Theme.colorScheme.price)
        )
    }


val LocalColorValues = staticCompositionLocalOf {
    ColorValues()
}
val LocalDimens = staticCompositionLocalOf {
    DimensionValues()
}
val LocalTypography = staticCompositionLocalOf<TypographyValues> {
    error("TypographyValues is not provided")
}

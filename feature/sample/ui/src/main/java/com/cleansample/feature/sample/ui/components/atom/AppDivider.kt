package com.cleansample.feature.sample.ui.components.atom

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.cleansample.ui_theme.Theme

@Composable
fun AppDivider(thickness: Dp = Theme.dimensions.smallDividerHeight) {
    Divider(
        thickness = thickness,
        color = Theme.colorScheme.divider,
    )
}
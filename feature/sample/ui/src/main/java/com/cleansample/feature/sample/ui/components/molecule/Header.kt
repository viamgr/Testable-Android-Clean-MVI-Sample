package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cleansample.feature.sample.ui.components.atom.AppDivider
import com.cleansample.ui_theme.Theme

@Composable
fun Header(text: String) {
    Text(
        modifier = Modifier.padding(vertical = Theme.dimensions.spaceLarge),
        text = text, style = Theme.typography.titleLarge)

    AppDivider()
}
package com.cleansample.feature.sample.ui.components.atom

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun PriceText(
    summary: Summary,
    paddingValues: PaddingValues = PaddingValues(vertical = Theme.dimensions.spaceSmall),
    textStyle: TextStyle = Theme.typography.titleLargePrice,
) {
    Text(
        modifier = Modifier.padding(paddingValues),
        style = textStyle,
        text = stringResource(id = R.string.price_currency,
            summary.price,
            summary.currency))
}
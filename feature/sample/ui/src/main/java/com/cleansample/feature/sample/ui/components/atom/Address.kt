package com.cleansample.feature.sample.ui.components.atom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun Address(
    summary: Summary,
    paddingValues: PaddingValues = PaddingValues(vertical = Theme.dimensions.spaceSmall),
    onAddressClicked: () -> Unit,
) {
    Text(
        modifier = Modifier
            .clickable(onClick = onAddressClicked)
            .padding(paddingValues),
        style = MaterialTheme.typography.bodyMedium,
        text = stringResource(
            id = R.string.address_format,
            summary.street,
            summary.zipCode,
            summary.city))
}
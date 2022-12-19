package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.feature.sample.ui.components.atom.Address
import com.cleansample.feature.sample.ui.components.atom.PriceText
import com.cleansample.feature.sample.ui.components.template.ContentWithLabelTemplate
import com.cleansample.ui_theme.Theme

@Composable
fun Summary(
    summary: Summary,
    textStyle: TextStyle = Theme.typography.bodyMediumInfo,
    paddingValues: PaddingValues = PaddingValues(
        vertical = Theme.dimensions.spaceMedium,
        horizontal = Theme.dimensions.spaceLarge
    ),
    onAddressClicked: () -> Unit = {},
) {
    ContentWithLabelTemplate(title = summary.title, paddingValues = paddingValues) {

        PriceText(summary)

        Address(summary, onAddressClicked = onAddressClicked)

        SummaryInfo(summary, textStyle)

    }
}


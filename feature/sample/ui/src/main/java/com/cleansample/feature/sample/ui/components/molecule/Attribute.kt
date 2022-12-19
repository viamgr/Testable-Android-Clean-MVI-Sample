package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.presentation.model.Attribute
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun Document(
    attribute: Attribute,
    textStyle: TextStyle = Theme.typography.bodyMedium,
    unitStyle: TextStyle = Theme.typography.bodyMediumInfo,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = Theme.dimensions.spaceLarge)) {
        Text(
            text = attribute.label,
            style = textStyle,
            modifier = Modifier.weight(1F)
        )

        Text(
            style = unitStyle,
            text = stringResource(
                id = R.string.unit_value,
                attribute.value,
                attribute.unit.orEmpty()))

    }
}
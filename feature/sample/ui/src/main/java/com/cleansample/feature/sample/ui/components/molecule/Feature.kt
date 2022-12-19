package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun Feature(
    label: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = Theme.typography.bodyMedium,
) {
    Row(
        modifier = modifier.padding(vertical = Theme.dimensions.spaceLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = label,
            tint = Color.Unspecified
        )

        Text(
            text = label,
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = Theme.dimensions.spaceMedium),
            style = textStyle
        )
    }
}
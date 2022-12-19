package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.components.template.ContentWithLabelTemplate
import com.cleansample.ui_theme.Theme

@Composable
fun Description(
    description: String,
    textStyle: TextStyle = Theme.typography.bodyMedium,
) {
    ContentWithLabelTemplate(
        title = stringResource(id = R.string.description_header),
        afterContent = {}
    ) {
        Text(
            description,
            style = textStyle,
            modifier = Modifier.padding(Theme.dimensions.spaceMedium),
        )
    }

}
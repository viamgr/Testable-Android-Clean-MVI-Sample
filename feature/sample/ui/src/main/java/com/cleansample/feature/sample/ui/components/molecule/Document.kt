package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.presentation.model.Document
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun Document(
    document: Document,
    modifier: Modifier,
    textStyle: TextStyle = Theme.typography.bodyMedium,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_document),
        tint = Color.Unspecified,
        contentDescription = document.title
    )

    Text(
        text = document.title,
        modifier = modifier.padding(horizontal = Theme.dimensions.spaceMedium),
        style = textStyle
    )

    Icon(
        tint = Color.Unspecified,
        painter = painterResource(id = R.drawable.chevron),
        contentDescription = document.title
    )
}
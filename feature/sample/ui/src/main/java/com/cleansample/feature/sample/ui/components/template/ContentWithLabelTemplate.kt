package com.cleansample.feature.sample.ui.components.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cleansample.feature.sample.ui.components.atom.AppDivider
import com.cleansample.feature.sample.ui.components.molecule.Header
import com.cleansample.ui_theme.Theme

@Composable
fun ContentWithLabelTemplate(
    title: String,
    paddingValues: PaddingValues = PaddingValues(horizontal = Theme.dimensions.spaceLarge),
    afterContent: (@Composable () -> Unit) = {
        AppDivider(thickness = Theme.dimensions.largeDividerHeight)
    },
    content: @Composable () -> Unit,
) {
    Column(modifier = Modifier.padding(paddingValues)) {

        Header(title)

        content()
    }

    afterContent()
}
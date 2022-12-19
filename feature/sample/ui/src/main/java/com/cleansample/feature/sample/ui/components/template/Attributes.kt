package com.cleansample.feature.sample.ui.components.template

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cleansample.feature.sample.presentation.model.Attribute
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.components.organism.AttributeList

@Composable
fun Attributes(attributes: List<Attribute>) {
    ContentWithLabelTemplate(stringResource(id = R.string.specifications_header)) {
        AttributeList(attributes)
    }
}
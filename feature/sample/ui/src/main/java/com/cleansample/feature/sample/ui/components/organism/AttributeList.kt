package com.cleansample.feature.sample.ui.components.organism

import androidx.compose.runtime.Composable
import com.cleansample.feature.sample.presentation.model.Attribute
import com.cleansample.feature.sample.ui.components.atom.AppDivider
import com.cleansample.feature.sample.ui.components.molecule.Document

@Composable
fun AttributeList(attributes: List<Attribute>) {
    for ((index, attribute) in attributes.withIndex()) {
        Document(attribute)

        if (index != attributes.size - 1) {
            AppDivider()
        }
    }
}
package com.cleansample.feature.sample.ui.components.organism

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cleansample.feature.sample.presentation.model.Document
import com.cleansample.feature.sample.ui.components.atom.AppDivider
import com.cleansample.feature.sample.ui.components.molecule.Document
import com.cleansample.ui_theme.Theme

@Composable
fun DocumentList(documents: List<Document>, onDocumentItemClicked: (String) -> Unit = {}) {
    for ((index, document) in documents.withIndex()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(onClick = {
                    onDocumentItemClicked(document.link)
                })
                .padding(vertical = Theme.dimensions.spaceLarge)
        ) {
            Document(document, modifier = Modifier.weight(1F))
        }

        if (index != documents.size - 1) {
            AppDivider()
        }
    }
}


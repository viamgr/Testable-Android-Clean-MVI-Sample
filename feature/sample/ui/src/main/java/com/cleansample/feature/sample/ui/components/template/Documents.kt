package com.cleansample.feature.sample.ui.components.template

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cleansample.feature.sample.presentation.detail.SampleDetailState
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.components.organism.DocumentList

@Composable
fun Documents(
    state: SampleDetailState,
    onDocumentItemClicked: (String) -> Unit,
) {
    ContentWithLabelTemplate(stringResource(id = R.string.documents_header)) {
        DocumentList(state.documents, onDocumentItemClicked)
    }
}
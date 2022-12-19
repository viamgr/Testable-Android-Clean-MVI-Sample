package com.cleansample.feature.sample.ui.components.template

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.components.organism.FeatureList

@Composable
fun Features(features: List<String>) {
    ContentWithLabelTemplate(stringResource(id = R.string.features_header)) {
        FeatureList(features)
    }
}
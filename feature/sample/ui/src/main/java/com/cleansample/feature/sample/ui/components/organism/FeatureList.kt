package com.cleansample.feature.sample.ui.components.organism

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cleansample.feature.sample.ui.components.atom.AppDivider
import com.cleansample.feature.sample.ui.components.molecule.Feature

@Composable
fun FeatureList(features: List<String>) {
    for (index in features.indices step 2) {
        Row {
            Feature(label = features[index], modifier = Modifier.weight(1F))

            features.getOrNull(index + 1)?.let {
                Feature(label = features[index + 1], modifier = Modifier.weight(1F))
            }
        }

        if (index != features.size - 1) {
            AppDivider()
        }
    }
}
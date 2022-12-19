package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.cleansample.feature.sample.presentation.detail.PresentationError
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun Error(
    onRetryClickedListenerEvent: () -> Unit,
    error: PresentationError,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onRetryClickedListenerEvent)
            .padding(Theme.dimensions.spaceLarge),
        verticalAlignment = CenterVertically
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
            contentDescription = null)
        Text(
            modifier = Modifier
                .padding(Theme.dimensions.spaceLarge),
            text = "${error.title} , ${error.description}"
        )
    }
}
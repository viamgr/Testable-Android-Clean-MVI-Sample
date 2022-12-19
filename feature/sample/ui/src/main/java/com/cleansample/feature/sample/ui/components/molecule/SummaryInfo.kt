package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.feature.sample.ui.R
import com.cleansample.ui_theme.Theme

@Composable
fun SummaryInfo(
    summary: Summary,
    textStyle: TextStyle,
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = Theme.dimensions.spaceSmall)) {

        Icon(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = summary.date,
            tint = Color.Unspecified
        )
        Text(
            text = summary.date,
            modifier = Modifier.weight(1F),
            style = textStyle,
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_visits),
            contentDescription = summary.visits.toString(),
            tint = Color.Unspecified
        )

        Text(
            text = summary.date,
            style = textStyle,
            modifier = Modifier.padding(end = Theme.dimensions.spaceLarge)
        )

        Text(
            text = stringResource(id = R.string.sample_id, summary.id),
            style = textStyle,
        )

    }
}
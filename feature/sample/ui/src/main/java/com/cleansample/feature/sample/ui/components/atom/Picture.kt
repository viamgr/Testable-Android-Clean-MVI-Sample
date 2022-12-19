package com.cleansample.feature.sample.ui.components.atom

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun Picture(
    picture: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        modifier = modifier,
        model = picture,
        contentDescription = picture,
        contentScale = ContentScale.Crop
    )
}
package com.cleansample.feature.sample.ui.components.molecule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cleansample.feature.sample.ui.components.atom.Picture
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(
    pictures: List<String>,
    onPictureItemClicked: (Int) -> Unit = {},
    modifier: Modifier,
) {
    HorizontalPager(modifier = modifier, count = pictures.size) { index ->
        Picture(pictures[index],
            Modifier
                .fillMaxWidth()
                .aspectRatio(1.4F)
                .clickable(onClick = { onPictureItemClicked(index) }))
    }
}
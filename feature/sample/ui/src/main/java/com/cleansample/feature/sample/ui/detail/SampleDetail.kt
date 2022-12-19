package com.cleansample.feature.sample.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent
import com.cleansample.feature.sample.presentation.detail.SampleDetailSideEffect
import com.cleansample.feature.sample.presentation.detail.SampleDetailState
import com.cleansample.feature.sample.presentation.detail.SampleDetailViewModel
import com.cleansample.feature.sample.ui.R
import com.cleansample.feature.sample.ui.components.molecule.Carousel
import com.cleansample.feature.sample.ui.components.molecule.Description
import com.cleansample.feature.sample.ui.components.molecule.Error
import com.cleansample.feature.sample.ui.components.molecule.Loading
import com.cleansample.feature.sample.ui.components.molecule.Summary
import com.cleansample.feature.sample.ui.components.template.Attributes
import com.cleansample.feature.sample.ui.components.template.Documents
import com.cleansample.feature.sample.ui.components.template.Features
import com.cleansample.presentation.dispatchIntent
import com.cleansample.ui_theme.Theme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun SampleDetailScreen(
    navigateToBrowserIntentCallback: (String) -> Unit,
    navigateToShareIntentCallback: (String) -> Unit,
    navigateToImageViewerCallback: (String) -> Unit,
    navigateGoogleMapsDirectionIntent: (String, String) -> Unit,
) {
    val viewModel = hiltViewModel<SampleDetailViewModel>()

    viewModel.collectSideEffect {
        when (it) {
            is SampleDetailSideEffect.OpenDocument -> navigateToBrowserIntentCallback(it.url)
            is SampleDetailSideEffect.OpenShareIntent -> navigateToShareIntentCallback(it.data)
            is SampleDetailSideEffect.OpenPictureScreen -> navigateToImageViewerCallback(it.url)
            is SampleDetailSideEffect.OpenMapsDirection -> navigateGoogleMapsDirectionIntent(
                it.latitude,
                it.longitude)
        }
    }

    val state by viewModel.collectAsState()

    SampleDetailUi(
        state = state,
        onPictureItemClicked = {
            viewModel.dispatchIntent(SampleDetailIntent.OnCarouselItemClickedListenerEvent(it))
        },
        onAddressClicked = {
            viewModel.dispatchIntent(SampleDetailIntent.OnAddressClickedListenerEvent)
        },
        onShareButtonClicked = {
            viewModel.dispatchIntent(SampleDetailIntent.OnShareClickedListenerEvent)
        },
        onDocumentItemClicked = {
            viewModel.dispatchIntent(SampleDetailIntent.OnDocumentClickListenerEvent(it))
        },
        onRetryClickedListenerEvent = {
            viewModel.dispatchIntent(SampleDetailIntent.OnRetryClickedListenerEvent)
        }
    )

}

@Composable
fun SampleDetailUi(
    state: SampleDetailState,
    onPictureItemClicked: (Int) -> Unit = {},
    onShareButtonClicked: () -> Unit = {},
    onDocumentItemClicked: (String) -> Unit = {},
    onAddressClicked: () -> Unit = {},
    onRetryClickedListenerEvent: () -> Unit = {},
) {
    if (state.isLoading) {
        Loading()
    } else if (state.error != null) {
        Error(onRetryClickedListenerEvent, state.error!!)
    } else {
        LazyColumn {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {

                    Carousel(state.pictures,
                        onPictureItemClicked = onPictureItemClicked,
                        modifier = Modifier.fillMaxWidth())

                    Icon(modifier = Modifier
                        .padding(Theme.dimensions.spaceLarge)
                        .clickable(onClick = onShareButtonClicked)
                        .align(Alignment.TopEnd)
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White.copy(alpha = 0.2F))
                        .padding(Theme.dimensions.spaceSmall),
                        painter = painterResource(id = R.drawable.ic_baseline_share_24),
                        contentDescription = "share")
                }
            }

            item {
                Summary(state.summary, onAddressClicked = onAddressClicked)
            }

            if (state.attributes.isNotEmpty()) {
                item {
                    Attributes(state.attributes)
                }
            }

            if (state.features.isNotEmpty()) {
                item {
                    Features(state.features)
                }
            }

            if (state.documents.isNotEmpty()) {
                item {
                    Documents(state, onDocumentItemClicked)
                }
            }

            item {
                Description(state.description)
            }
        }

    }
}



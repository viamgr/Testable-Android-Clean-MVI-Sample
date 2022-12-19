package com.cleansample.feature.sample.presentation.detail

import com.cleansample.feature.sample.presentation.IMAGE_SIZE_KEY
import com.cleansample.feature.sample.presentation.IMAGE_SIZE_LARGE
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.Init
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.OnAddressClickedListenerEvent
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.OnCarouselItemClickedListenerEvent
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.OnDocumentClickListenerEvent
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.OnRetryClickedListenerEvent
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent.OnShareClickedListenerEvent
import com.cleansample.presentation.BaseViewModel
import com.cleansample.presentation.dispatchIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class SampleDetailViewModel @Inject constructor(
    private val getSampleDetailResponse: GetSampleDetailResponse,
    override val reducer: GetSampleDetailReducer = GetSampleDetailReducer(),
) : BaseViewModel<SampleDetailIntent, SampleDetailState, SampleDetailEffect, SampleDetailSideEffect,
        SampleDetailEvent>(SampleDetailState()) {

    init {
        dispatchIntent(Init)
    }

    private fun handleOpenDocumentIntent(documentUrl: String) =
        flowOf(SampleDetailSideEffect.OpenDocument(documentUrl))

    private fun handleShareClickedListenerIntent(): Flow<SampleDetailSideEffect.OpenShareIntent> {
        return flowOf(SampleDetailSideEffect.OpenShareIntent(getSampleDetailResponse.sampleId.toString()))
    }

    private fun handleAddressClickedListener() = flowOf(
        SampleDetailSideEffect.OpenMapsDirection(
            latitude = getSampleDetailResponse.cachedLatitude,
            longitude = getSampleDetailResponse.cachedLongitude
        ))

    private fun handleCarouselItemClickedListenerIntent(position: Int): Flow<SampleDetailSideEffect.OpenPictureScreen> {
        return getSampleDetailResponse.cachedPictures
            .getOrNull(position)
            ?.let {
                flowOf(SampleDetailSideEffect.OpenPictureScreen(
                    it.replace(IMAGE_SIZE_KEY, IMAGE_SIZE_LARGE)
                ))
            } ?: error(IllegalStateException())
    }


    override suspend fun handleIntent(intent: SampleDetailIntent): Flow<SampleDetailEvent> {
        return when (intent) {
            Init -> handleGetSampleDetailResponse()
            OnAddressClickedListenerEvent -> handleAddressClickedListener()
            is OnCarouselItemClickedListenerEvent -> handleCarouselItemClickedListenerIntent(intent.position)
            is OnDocumentClickListenerEvent -> handleOpenDocumentIntent(intent.documentUrl)
            OnRetryClickedListenerEvent -> handleGetSampleDetailResponse()
            OnShareClickedListenerEvent -> handleShareClickedListenerIntent()
        }
    }

    private suspend fun handleGetSampleDetailResponse() = getSampleDetailResponse()

}
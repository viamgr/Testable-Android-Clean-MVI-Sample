package com.cleansample.feature.sample.presentation.detail

import com.cleansample.presentation.pattern.SideEffect


sealed interface SampleDetailSideEffect : SideEffect, SampleDetailEvent {
    data class OpenDocument(val url: String) : SampleDetailSideEffect

    data class OpenShareIntent(val data: String) : SampleDetailSideEffect

    data class OpenMapsDirection(val latitude: String, val longitude: String) :
        SampleDetailSideEffect

    data class OpenPictureScreen(val url: String) : SampleDetailSideEffect
}
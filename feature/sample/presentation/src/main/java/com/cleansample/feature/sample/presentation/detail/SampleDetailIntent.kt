package com.cleansample.feature.sample.presentation.detail

import com.cleansample.presentation.pattern.Intent

sealed interface SampleDetailIntent : Intent, SampleDetailEvent {
    object Init : SampleDetailIntent

    data class OnDocumentClickListenerEvent(val documentUrl: String) : SampleDetailIntent

    object OnRetryClickedListenerEvent : SampleDetailIntent

    data class OnCarouselItemClickedListenerEvent(val position: Int) : SampleDetailIntent

    object OnShareClickedListenerEvent : SampleDetailIntent

    object OnAddressClickedListenerEvent : SampleDetailIntent
}



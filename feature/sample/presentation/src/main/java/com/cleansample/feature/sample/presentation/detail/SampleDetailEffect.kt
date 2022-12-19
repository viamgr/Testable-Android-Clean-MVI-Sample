package com.cleansample.feature.sample.presentation.detail

import com.cleansample.presentation.pattern.Effect
import com.cleansample.use_case.samples.GetSampleDetailUseCase

sealed interface SampleDetailEffect : Effect, SampleDetailEvent {
    data class InitEffect(val response: GetSampleDetailUseCase.Response) : SampleDetailEffect

    data class LoadingEffect(val loadingState: Boolean) : SampleDetailEffect

    data class ErrorEffect(val error: PresentationError) : SampleDetailEffect
}


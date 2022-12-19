package com.cleansample.feature.sample.presentation.detail

import com.cleansample.core.errors.NetworkError
import com.cleansample.core.errors.NoInternet
import com.cleansample.core.errors.Timeout
import com.cleansample.core.errors.UnknownHost
import com.cleansample.feature.sample.presentation.model.Attribute
import com.cleansample.feature.sample.presentation.model.Document
import com.cleansample.feature.sample.presentation.model.Summary
import com.cleansample.presentation.pattern.State
import com.cleansample.use_case.samples.GetSampleDetailUseCase

data class SampleDetailState(
    val description: String = "",
    val documents: List<Document> = emptyList(),
    val summary: Summary = Summary(),
    val attributes: List<Attribute> = emptyList(),
    val features: List<String> = emptyList(),
    val pictures: List<String> = emptyList(),
    val isLoading: Boolean = true,
    val error: PresentationError? = null,
) : State

fun GetSampleDetailResponse.GetSampleDetailResponseError.toMessage(
    state: SampleDetailState,
    throwable: Throwable,
): PresentationError =
    when (this) {
        is GetSampleDetailResponse.PresentationUnHandledError -> PresentationError("An UnHandled Error in the top layers",
            errorType.toString())
        is GetSampleDetailResponse.PresentationUseCaseError -> PresentationError("An UseCase Handled error",
            useCaseError.toString())
        is GetSampleDetailResponse.PresentationNetworkError -> PresentationError("An UseCase Handled error",
            networkError.toString())
    }

fun NetworkError.toMessage(state: SampleDetailState, throwable: Throwable): PresentationError =
    when (this) {
        NoInternet -> PresentationError("NoInternet", throwable.message.toString())
        is Timeout -> PresentationError("Timeout with in: ", this.time.toString())
        UnknownHost -> PresentationError("UnknownHost", ", Please Retry")
    }

fun GetSampleDetailUseCase.GetSampleDetailUseCaseError.toMessage(
    state: SampleDetailState,
    throwable: Throwable,
): PresentationError =
    when (this) {
        GetSampleDetailUseCase.GetSampleDetailUseCaseErrorTypeA -> PresentationError("GetSampleDetailUseCaseErrorTypeA",
            throwable.message.toString())
        GetSampleDetailUseCase.GetSampleDetailUseCaseErrorTypeB -> PresentationError("GetSampleDetailUseCaseErrorTypeB",
            throwable.message.toString())
    }


data class PresentationError(val title: String, val description: String)
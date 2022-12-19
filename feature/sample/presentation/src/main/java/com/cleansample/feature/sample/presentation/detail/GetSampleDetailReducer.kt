package com.cleansample.feature.sample.presentation.detail

import com.cleansample.feature.sample.presentation.mapper.mapAdDetail
import com.cleansample.presentation.pattern.Reducer
import javax.inject.Inject

class GetSampleDetailReducer @Inject constructor() :
    Reducer<SampleDetailState, SampleDetailEffect> {
    override fun reduce(
        state: SampleDetailState,
        effect: SampleDetailEffect,
    ): SampleDetailState {
        return when (effect) {
            is SampleDetailEffect.ErrorEffect -> state.copy(error = effect.error)
            is SampleDetailEffect.InitEffect -> effect.response.mapAdDetail(state)
            is SampleDetailEffect.LoadingEffect -> state.copy(isLoading = effect.loadingState)
        }
    }

}
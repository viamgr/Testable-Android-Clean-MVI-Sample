package com.cleansample.feature.sample.presentation

import com.cleansample.core.WrappedResult
import com.cleansample.core.fold
import com.cleansample.presentation.pattern.Effect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

inline fun <EF : Effect, reified ER> Flow<WrappedResult<out EF>>.mapError(crossinline onError: (ER, Throwable) -> EF): Flow<EF> {
    return map {
        it.fold({ value ->
            value
        }, { errorType: ER, throwable ->
            onError(errorType, throwable)
        })
    }
}

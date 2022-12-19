package com.cleansample.presentation

import com.cleansample.presentation.pattern.Effect
import com.cleansample.presentation.pattern.Event
import com.cleansample.presentation.pattern.Intent
import com.cleansample.presentation.pattern.SideEffect
import com.cleansample.presentation.pattern.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

@Suppress("UNCHECKED_CAST")
fun <INTENT : Intent, STATE : State, EFFECT : Effect, SIDE_EFFECT : SideEffect, EVENT : Event>
        ReducerContainerHost<INTENT, STATE, EFFECT, SIDE_EFFECT, EVENT>.dispatchIntent(
    intent: INTENT,
) =
    intent {
        handleIntent(intent)
            .onEach { event ->
                when (event) {
                    is SideEffect -> postSideEffect(event as SIDE_EFFECT)
                    is Effect -> reduce {
                        reducer.reduce(state, event as EFFECT)
                    }
                }

            }.collect()
    }

inline fun <E : Effect> Flow<E>.beforeEffect(
    crossinline before: () -> E,
): Flow<E> =
    flow {
        emit(before())
        emitAll(this@beforeEffect)
    }


inline fun <E : Event> Flow<E>.afterEffect(
    crossinline after: () -> E,
): Flow<E> =
    flow {
        emitAll(this@afterEffect)
        emit(after())
    }


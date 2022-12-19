package com.cleansample.presentation

import com.cleansample.presentation.pattern.Effect
import com.cleansample.presentation.pattern.Event
import com.cleansample.presentation.pattern.Intent
import com.cleansample.presentation.pattern.Reducer
import com.cleansample.presentation.pattern.SideEffect
import com.cleansample.presentation.pattern.State
import kotlinx.coroutines.flow.Flow
import org.orbitmvi.orbit.ContainerHost

interface ReducerContainerHost<INTENT : Intent, STATE : State, EFFECT : Effect, SIDE_EFFECT : SideEffect, EVENT : Event> :
    ContainerHost<STATE, SIDE_EFFECT> {

    val reducer: Reducer<STATE, EFFECT>

    suspend fun handleIntent(intent: INTENT): Flow<EVENT>
}

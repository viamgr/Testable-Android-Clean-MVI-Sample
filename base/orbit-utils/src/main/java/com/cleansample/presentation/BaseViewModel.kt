package com.cleansample.presentation

import androidx.lifecycle.ViewModel
import com.cleansample.presentation.pattern.Effect
import com.cleansample.presentation.pattern.Event
import com.cleansample.presentation.pattern.Intent
import com.cleansample.presentation.pattern.SideEffect
import com.cleansample.presentation.pattern.State
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container

abstract class BaseViewModel<INTENT : Intent, STATE : State, EFFECT : Effect, SIDE_EFFECT : SideEffect, EVENT : Event>(
    initialState: STATE,
) : ViewModel(),
    ReducerContainerHost<INTENT, STATE, EFFECT, SIDE_EFFECT, EVENT> {

    override val container: Container<STATE, SIDE_EFFECT> = container(initialState)

}
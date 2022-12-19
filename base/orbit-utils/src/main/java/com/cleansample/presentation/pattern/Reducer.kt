package com.cleansample.presentation.pattern


interface Reducer<STATE : State, EFFECT : Effect> {
    fun reduce(state: STATE, effect: EFFECT): STATE
}
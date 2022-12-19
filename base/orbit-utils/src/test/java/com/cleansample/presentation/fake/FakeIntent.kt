package com.cleansample.presentation.fake

import com.cleansample.presentation.pattern.Effect
import com.cleansample.presentation.pattern.Intent
import com.cleansample.presentation.pattern.State

sealed interface FakeIntent : Intent
object IntentOne : FakeIntent
object IntentTwo : FakeIntent
data class FakeCounterState(val count: Int) : State


sealed interface FakeEffect : Effect
object FakeEffect1 : FakeEffect
object FakeEffect2 : FakeEffect

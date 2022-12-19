package com.cleansample.presentation

import app.cash.turbine.test
import com.cleansample.presentation.fake.FakeCounterState
import com.cleansample.presentation.fake.FakeEffect
import com.cleansample.presentation.fake.FakeEffect1
import com.cleansample.presentation.fake.FakeEffect2
import com.cleansample.presentation.fake.FakeIntent
import com.cleansample.presentation.fake.IntentOne
import com.cleansample.presentation.fake.IntentTwo
import com.cleansample.presentation.pattern.Event
import com.cleansample.presentation.pattern.Reducer
import com.cleansample.presentation.pattern.SideEffect
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestScope
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import org.orbitmvi.orbit.container
import kotlin.coroutines.CoroutineContext

@OptIn(DelicateCoroutinesApi::class)
class OrbitUtilsBehaviorSpec : BehaviorSpec() {

    init {

        Given("ReducerContainerHost in the multi-thread env") {
            val initialState = FakeCounterState(0)

            val realOrbitContainer = container<FakeCounterState, SideEffect>(initialState)

            val mockContainer =
                mockk<ReducerContainerHost<FakeIntent, FakeCounterState, FakeEffect, SideEffect, Event>>()

            every { mockContainer.container } returns realOrbitContainer

            When("dispatch multiple intents in the multiple thread") {

                Then("faked container should have same instance") {
                    mockContainer.container shouldBeSameInstanceAs realOrbitContainer
                }

                val effectsOfIntent1 = flowOf(FakeEffect1)
                val effectsOfIntent2 = flowOf(FakeEffect2)
                val effectValue1 = 1
                val effectValue2 = 1

                val fakeReducer = object : Reducer<FakeCounterState, FakeEffect> {
                    override fun reduce(
                        state: FakeCounterState,
                        effect: FakeEffect,
                    ): FakeCounterState {
                        return when (effect) {
                            FakeEffect1 -> state.copy(count = state.count + effectValue1)
                            FakeEffect2 -> state.copy(count = state.count + effectValue2)
                        }
                    }

                }

                every { mockContainer.reducer } returns fakeReducer

                coEvery { mockContainer.handleIntent(IntentOne) } returns effectsOfIntent1
                coEvery { mockContainer.handleIntent(IntentTwo) } returns effectsOfIntent2

                val testIntentRepeat1 = 1000
                val testIntentRepeat2 = 1000

                Then("state flow should be sequentially the same as the order of the reduced events") {
                    mockContainer.container.stateFlow.test {
                        joinAll(
                            runInThread(mockContainer,
                                IntentOne,
                                testIntentRepeat1,
                                newFixedThreadPoolContext(10, "Test1")),
                            runInThread(mockContainer,
                                IntentTwo,
                                testIntentRepeat2,
                                newFixedThreadPoolContext(10, "Test2")),
                        )

                        repeat(testIntentRepeat1 + testIntentRepeat2 + 1) {
                            awaitItem().count shouldBe it
                        }
                        cancelAndIgnoreRemainingEvents()
                    }
                }

                Then("the final result should be set correctly") {
                    val expectedResult =
                        (testIntentRepeat1 * effectValue1) + (testIntentRepeat2 * effectValue2)
                    mockContainer.container.stateFlow.value.count shouldBe expectedResult
                }
            }
        }

        Given("ReducerContainerHost in the same thread") {

            val initialState = FakeCounterState(0)

            val realOrbitContainer = container<FakeCounterState, SideEffect>(initialState)

            val mockContainer =
                mockk<ReducerContainerHost<FakeIntent, FakeCounterState, FakeEffect, SideEffect, Event>>()

            every { mockContainer.container } returns realOrbitContainer

            When("dispatch multiple intents with the multiple effect-outputs") {

                val effectsOfIntent1 = flowOf(FakeEffect1, FakeEffect2)
                val effectsOfIntent2 = flowOf(FakeEffect2, FakeEffect1)
                val effectValue1 = -20
                val effectValue2 = 50

                val fakeReducer = object : Reducer<FakeCounterState, FakeEffect> {
                    override fun reduce(
                        state: FakeCounterState,
                        effect: FakeEffect,
                    ): FakeCounterState {
                        return when (effect) {
                            FakeEffect1 -> state.copy(count = state.count + effectValue1)
                            FakeEffect2 -> state.copy(count = state.count + effectValue2)
                        }
                    }
                }

                every { mockContainer.reducer } returns fakeReducer

                coEvery { mockContainer.handleIntent(IntentOne) } returns effectsOfIntent1
                coEvery { mockContainer.handleIntent(IntentTwo) } returns effectsOfIntent2


                Then("the collect order be correct") {
                    val firstIntentValue = effectValue1 + effectValue2
                    val secondIntentValue = effectValue1 + effectValue2

                    mockContainer.container.stateFlow.test {

                        mockContainer.dispatchIntent(IntentOne)
                        mockContainer.dispatchIntent(IntentTwo)

                        awaitItem().count shouldBe initialState.count
                        awaitItem().count shouldBe firstIntentValue
                        awaitItem().count shouldBe firstIntentValue + secondIntentValue

                        cancelAndIgnoreRemainingEvents()
                    }
                }
                Then("the final result should be set correctly") {
                    val expectedResult =
                        (effectValue1) + (effectValue2) + (effectValue2) + (effectValue1)
                    mockContainer.container.stateFlow.value.count shouldBe expectedResult
                }
            }
        }
    }

    private fun TestScope.runInThread(
        testSubject: ReducerContainerHost<FakeIntent, FakeCounterState, FakeEffect, SideEffect, Event>,
        intent: FakeIntent,
        repeat: Int,
        executorCoroutineDispatcher: CoroutineContext,
    ) = launch(context = executorCoroutineDispatcher) {
        repeat(repeat) {
            testSubject.dispatchIntent(intent)
        }
    }
}

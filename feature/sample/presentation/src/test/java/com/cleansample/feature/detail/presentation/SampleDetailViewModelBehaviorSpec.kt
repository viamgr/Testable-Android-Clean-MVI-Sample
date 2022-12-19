package com.cleansample.feature.detail.presentation

import com.cleansample.feature.sample.presentation.IMAGE_SIZE_KEY
import com.cleansample.feature.sample.presentation.IMAGE_SIZE_LARGE
import com.cleansample.feature.sample.presentation.detail.GetSampleDetailResponse
import com.cleansample.feature.sample.presentation.detail.SampleDetailEffect
import com.cleansample.feature.sample.presentation.detail.SampleDetailIntent
import com.cleansample.feature.sample.presentation.detail.SampleDetailSideEffect
import com.cleansample.feature.sample.presentation.detail.SampleDetailState
import com.cleansample.feature.sample.presentation.detail.SampleDetailViewModel
import com.cleansample.presentation.afterEffect
import com.cleansample.presentation.dispatchIntent
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.orbitmvi.orbit.test

internal class SampleDetailViewModelBehaviorSpec : FunSpec() {

    private lateinit var target: SampleDetailViewModel
    private var getSampleDetailResponse: GetSampleDetailResponse = mockk()

    override fun isolationMode() = IsolationMode.InstancePerTest

    private fun createViewModel() {
        target = SampleDetailViewModel(
            getSampleDetailResponse = getSampleDetailResponse,
        )
    }

    init {

        test("call load sample detail intent on effect should change the view state") {

            val initialState = SampleDetailState()

            val effect = SampleDetailEffect.InitEffect(mockk(relaxed = true))
            coEvery { getSampleDetailResponse() } returns flowOf(effect)

            createViewModel()

            val testSubject = target.test(initialState)
            testSubject.testIntent {
                dispatchIntent(SampleDetailIntent.Init)
            }
            testSubject.assert(initialState) {
                states(
                    { initialState.copy() },
                    { initialState.copy(isLoading = false) },
                )
            }
        }

        test("call load sample detail intent on success result should change the view state") {
            val initialState = SampleDetailState(isLoading = false)

            val initEffect = SampleDetailEffect.InitEffect(mockk(relaxed = true))

            val effects = flowOf(initEffect).afterEffect {
                SampleDetailEffect.LoadingEffect(true)
            }

            coEvery { getSampleDetailResponse() } returns effects

            createViewModel()

            val testSubject = target.test(initialState)
            testSubject.testIntent {
                dispatchIntent(SampleDetailIntent.Init)
            }
            testSubject.assert(initialState) {
                states(
                    { initialState.copy(isLoading = true) },
                )
            }
        }


        test("call load sample detail event should get sample and map success result") {

            coEvery { getSampleDetailResponse() } returns flowOf(SampleDetailEffect.InitEffect(mockk(
                relaxed = true)))

            createViewModel()

            coVerify(exactly = 1) {
                getSampleDetailResponse.invoke()
            }
        }

        test("on document click listener event should call open document effect") {

            createViewModel()

            val testSubject = target.test()
            val expectedDocumentUrl = "expectedUrl"


            testSubject.testIntent {
                dispatchIntent(SampleDetailIntent.OnDocumentClickListenerEvent(expectedDocumentUrl))
            }

            testSubject.assert(SampleDetailState()) {
                postedSideEffects(
                    SampleDetailSideEffect.OpenDocument(expectedDocumentUrl),
                )
            }
        }


        test("on carousel item clicked listener event should open picture screen with correct url") {

            val imageUrl = "AAA${IMAGE_SIZE_KEY}AAA"
            val pictures = listOf("0000{imageId}000", imageUrl, "12222{imageId}222")

            val expectedResult = "AAA${IMAGE_SIZE_LARGE}AAA"

            coEvery { getSampleDetailResponse.cachedPictures } returns pictures

            createViewModel()

            val testSubject = target.test()
            testSubject.testIntent {
                dispatchIntent(SampleDetailIntent.OnCarouselItemClickedListenerEvent(1))
            }

            testSubject.assert(SampleDetailState()) {
                postedSideEffects(
                    SampleDetailSideEffect.OpenPictureScreen(expectedResult),
                )
            }
        }
    }
}
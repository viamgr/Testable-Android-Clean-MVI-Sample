package com.cleansample.samples

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cleansample.MainActivity
import com.cleansample.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class SampleActivityInstrumentedTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Before
    fun prepareTest() {
        hiltRule.inject()

    }

    @Test
    fun todoTest() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)


        activityScenario.close()
    }


}

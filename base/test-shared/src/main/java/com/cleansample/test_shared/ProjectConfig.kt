package com.cleansample.test_shared

import io.kotest.core.config.AbstractProjectConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

class ProjectConfig : AbstractProjectConfig() {

    override var testCoroutineDispatcher = true

    override suspend fun beforeProject() {
        super.beforeProject()
        Dispatchers.setMain(TestDispatchers.UnconfinedTestDispatcher)
    }

    override suspend fun afterProject() {
        super.afterProject()
        Dispatchers.resetMain()
    }

}
package com.cleansample.remote.interceptor

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import okhttp3.Interceptor

class BasicAuthInterceptorTest : ShouldSpec() {
    init {
        should("on fake username and password basic auth interceptor should set header correctly") {
            val slot = slot<String>()
            val chain = mockk<Interceptor.Chain>(relaxed = true)
            every {
                chain.request().newBuilder().header("Authorization", capture(slot))
            } returns mockk(
                relaxed = true)
            BasicAuthInterceptor("username", "password")
                .intercept(chain)

            slot.captured shouldBe "Basic dXNlcm5hbWU6cGFzc3dvcmQ="
        }
    }

}
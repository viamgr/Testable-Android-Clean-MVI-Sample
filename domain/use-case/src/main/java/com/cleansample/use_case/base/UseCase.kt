package com.cleansample.use_case.base

import com.cleansample.core.WrappedResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameter: P): WrappedResult<R> {
        return withContext(coroutineDispatcher) {
            execute(parameter)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameter: P): WrappedResult<R>
}
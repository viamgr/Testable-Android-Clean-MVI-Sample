package com.cleansample.core

fun <R, E> Throwable.toResult(errorType: E): WrappedResult<R> {
    return WrappedResult.failure<R, E>(errorType, this)
}
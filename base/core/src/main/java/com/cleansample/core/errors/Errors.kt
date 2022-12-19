package com.cleansample.core.errors

sealed interface BaseError

sealed interface RemoteError : BaseError
object UnknownError : BaseError

sealed interface NetworkError : RemoteError
sealed interface ServerError : RemoteError

data class Timeout(val time: Int) : NetworkError
object UnknownHost : NetworkError
object NoInternet : NetworkError

object ForbiddenError : ServerError
object UnAuthorized : ServerError
data class ApiError(val code: Int, val message: String) : ServerError
data class ItemNotFound<T>(val item: T) : ServerError


data class InvalidItemId<T>(val id: T) : ServerError


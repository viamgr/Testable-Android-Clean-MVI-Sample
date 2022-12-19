package com.cleansample.remote.base

import com.cleansample.core.WrappedResult
import com.cleansample.core.errors.ApiError
import com.cleansample.core.errors.ForbiddenError
import com.cleansample.core.errors.NoInternet
import com.cleansample.core.errors.Timeout
import com.cleansample.core.errors.UnAuthorized
import com.cleansample.core.errors.UnknownHost
import com.cleansample.core.toResult
import retrofit2.HttpException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

internal abstract class BaseRequest<PARAMS, RESPONSE> {
    abstract suspend fun request(params: PARAMS): WrappedResult<RESPONSE>

    suspend operator fun invoke(params: PARAMS): WrappedResult<RESPONSE> {
        return try {
            request(params)
        } catch (e: UnknownHostException) {
            e.toResult(UnknownHost)
        } catch (e: java.io.IOException) {
            e.toResult(NoInternet)
        } catch (e: TimeoutException) {
            e.toResult(Timeout(e.hashCode()))
        } catch (e: HttpException) {
            if (e.code() == 401) {
                e.toResult(UnAuthorized)
            } else if (e.code() == 403) {
                e.toResult(ForbiddenError)
            } else {
                e.toResult(ApiError(e.code(), e.message()))
            }
        }
    }
}
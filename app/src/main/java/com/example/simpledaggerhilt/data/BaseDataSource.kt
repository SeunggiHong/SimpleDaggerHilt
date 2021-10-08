package com.example.simpledaggerhilt.data

import retrofit2.Response
import timber.log.Timber
import java.lang.Exception

abstract class BaseDataSource {

    protected suspend fun <T> getResult(request: suspend () -> Response<T>): BaseResource<T> {
        try {
            val response = request()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return BaseResource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): BaseResource<T> {
        Timber.d(message)
        return BaseResource.error("Network call has failed for a following reason: $message")
    }


}
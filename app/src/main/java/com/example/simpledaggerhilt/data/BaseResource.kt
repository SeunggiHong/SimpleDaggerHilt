package com.example.simpledaggerhilt.data

data class BaseResult <out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): BaseResult<T> {
            return BaseResult(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, error: BaseError?): BaseResult<T> {
            return BaseResult(Status.ERROR, null, message)
        }

        fun <T> loading(data: T? = null): BaseResult<T> {
            return BaseResult(Status.LOADING, data, null)
        }
    }

}
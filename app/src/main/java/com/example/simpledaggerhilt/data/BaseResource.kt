package com.example.simpledaggerhilt.data

data class BaseResource <out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): BaseResource<T> {
            return BaseResource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String?, data: T? = null): BaseResource<T> {
            return BaseResource(Status.ERROR, null, message)
        }

        fun <T> loading(data: T? = null): BaseResource<T> {
            return BaseResource(Status.LOADING, data, null)
        }
    }

}
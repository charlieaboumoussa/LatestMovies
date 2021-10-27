package com.example.latestmovies.base.models

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Any<T>(data: T?, private var successMessage : String = "") : Resource<T>(data, successMessage)
    class Success<T>(data: T?, private var successMessage : String = "") : Resource<T>(data, successMessage)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Failed<T>(private var errorMessage: String = "", var dataOnFailed: T? = null) : Resource<T>(dataOnFailed, errorMessage)
    class Exception<T>(private var exception : String = "", data: T? = null) : Resource<T>(data, exception)
    class ConnectionNotAvailable<T>(message: String) : Resource<T>(null, message)
}

enum class Status {
    SUCCESS,
    LOADING,
    FAILED,
    EXCEPTION,
    CONNECTION_NOT_AVAILABLE
}
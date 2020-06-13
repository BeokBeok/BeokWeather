package com.example.beokweather.util

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val exception: Exception) : Result<Nothing>()
}

val Result<*>.isSuccess get() = this is Result.Success && data != null
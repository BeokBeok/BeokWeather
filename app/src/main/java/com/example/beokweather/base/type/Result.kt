package com.example.beokweather.base.type

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val exception: Exception) : Result<Nothing>()
}
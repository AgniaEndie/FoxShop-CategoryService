package ru.agniaendie.categoryservice.dto

sealed class ResultRequest<T> {
    data class Success<T>(val data: T) : ResultRequest<T>()
    data class Failure<T>(val error: Any) : ResultRequest<T>()
}
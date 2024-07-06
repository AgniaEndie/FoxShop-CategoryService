package ru.agniaendie.categoryservice.exception

class JwtValidationFailedException(override val message: String?) : RuntimeException() {
}
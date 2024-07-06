package ru.agniaendie.categoryservice.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ru.agniaendie.categoryservice.exception.AuthorizationHeaderUndefinedException
import ru.agniaendie.categoryservice.exception.JwtValidationFailedException

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(AuthorizationHeaderUndefinedException::class)
    fun handleAuthorizationHeaderException(ex: AuthorizationHeaderUndefinedException): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(JwtValidationFailedException::class)
    fun handleJwtValidationException(ex: JwtValidationFailedException): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }
}
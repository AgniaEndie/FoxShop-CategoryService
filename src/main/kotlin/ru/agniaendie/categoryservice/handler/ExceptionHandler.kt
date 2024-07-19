package ru.agniaendie.categoryservice.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ru.agniaendie.categoryservice.dto.ErrorDTO
import ru.agniaendie.categoryservice.exception.AuthorizationHeaderUndefinedException
import ru.agniaendie.categoryservice.exception.DataNotFoundException
import ru.agniaendie.categoryservice.exception.JwtValidationFailedException

@ControllerAdvice
@Component
class ExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(AuthorizationHeaderUndefinedException::class)
    fun handleAuthorizationHeaderException(ex: AuthorizationHeaderUndefinedException): ResponseEntity<Any> {
        logger.error(ex.message)
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(JwtValidationFailedException::class)
    fun handleJwtValidationException(ex: JwtValidationFailedException): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.UNAUTHORIZED)
    }
    @ExceptionHandler(DataNotFoundException::class)
    fun handleDataNotFoundException(ex: DataNotFoundException): ResponseEntity<Any> {
        return ResponseEntity(ErrorDTO("Category not found"),HttpStatus.NOT_FOUND)
    }
}
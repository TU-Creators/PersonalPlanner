package at.tucoders.personalplanner.util

import at.tucoders.personalplanner.controller.dto.ErrorResponseDto
import at.tucoders.personalplanner.exception.MappedBackendException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {


    @ExceptionHandler(MappedBackendException::class)
    fun handleNotFoundException(e: MappedBackendException): ResponseEntity<ErrorResponseDto> {
        return ResponseEntity(ErrorResponseDto(e.message ?: "An exception occured"), e.status)
    }
}
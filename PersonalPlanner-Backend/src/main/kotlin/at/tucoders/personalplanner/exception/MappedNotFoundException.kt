package at.tucoders.personalplanner.exception

import org.springframework.http.HttpStatus

class MappedNotFoundException(
    message: String?
) : MappedBackendException(message, HttpStatus.NOT_FOUND) {

}
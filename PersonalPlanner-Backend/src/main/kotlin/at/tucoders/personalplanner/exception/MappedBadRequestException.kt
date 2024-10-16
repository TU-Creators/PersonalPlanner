package at.tucoders.personalplanner.exception

import org.springframework.http.HttpStatus

class MappedBadRequestException(
    message: String?
) : MappedBackendException(message, HttpStatus.BAD_REQUEST) {

}
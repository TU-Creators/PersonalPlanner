package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.UserDto
import at.tucoders.personalplanner.mapper.UserMapper.Companion.toDto
import at.tucoders.personalplanner.persistance.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun findAll(): List<UserDto> {
        return userRepository.findAll().map { it.toDto() }
    }
}

package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.UserDto
import at.tucoders.personalplanner.mapper.UserMapper.Companion.toDto
import at.tucoders.personalplanner.persistance.UserEntity
import at.tucoders.personalplanner.persistance.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val securityService: SecurityService,
    private val userRepository: UserRepository
) {
    fun findAll(): List<UserDto> {
        return userRepository.findAll().map { it.toDto() }
    }

    fun findOrCreateCurrentUserEntity(): UserEntity {
        val currentUser = securityService.getCurrentUser()

        var currentUserEntity = userRepository.findByUserId(currentUser.userId)

        if(currentUserEntity == null) {
            currentUserEntity = UserEntity(
                null,
                currentUser.userId,
                currentUser.username,
                currentUser.email,
                emptySet()
            )

            userRepository.saveAndFlush(currentUserEntity)
        }

        return currentUserEntity
    }

}

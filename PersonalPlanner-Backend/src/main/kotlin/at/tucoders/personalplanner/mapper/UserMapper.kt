package at.tucoders.personalplanner.mapper

import at.tucoders.personalplanner.controller.dto.UserDto
import at.tucoders.personalplanner.persistance.UserEntity

class UserMapper {
    companion object {
        fun UserEntity.toDto(): UserDto {
            return UserDto(
                this.id,
                this.userId,
                this.name,
                this.email
            )
        }
    }
}

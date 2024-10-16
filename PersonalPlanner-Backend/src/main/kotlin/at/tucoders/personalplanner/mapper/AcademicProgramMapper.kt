package at.tucoders.personalplanner.mapper

import at.tucoders.personalplanner.controller.dto.AcademicProgramDto
import at.tucoders.personalplanner.persistance.AcademicProgramEntity
import at.tucoders.personalplanner.persistance.CourseEntity
import at.tucoders.personalplanner.persistance.UserEntity

class AcademicProgramMapper {
    companion object {
        fun AcademicProgramEntity.toDto(): AcademicProgramDto {
            return AcademicProgramDto(
                this.id,
                this.identifier,
                this.name,
                this.startingYear,
                this.startingSemester,
                this.requiredEcts
            )
        }

        fun AcademicProgramEntity.updateFromDto(dto: AcademicProgramDto) {
            this.identifier = dto.identifier
            this.name = dto.name
            this.startingYear = dto.startingYear
            this.startingSemester = dto.startingSemester
            this.requiredEcts = dto.requiredEcts
        }

        fun AcademicProgramDto.toEntity(user: UserEntity, courses: Set<CourseEntity>): AcademicProgramEntity {
            return AcademicProgramEntity(
                this.id,
                this.identifier,
                this.name,
                this.startingYear,
                this.startingSemester,
                this.requiredEcts,
                user,
                courses
            )
        }
    }
}

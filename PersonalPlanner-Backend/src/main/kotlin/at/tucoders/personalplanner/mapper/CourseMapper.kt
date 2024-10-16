package at.tucoders.personalplanner.mapper

import at.tucoders.personalplanner.controller.dto.CourseDto
import at.tucoders.personalplanner.persistance.CourseEntity

class CourseMapper {
    companion object {
        fun CourseEntity.toDto(): CourseDto {
            return CourseDto(
                this.id,
                this.identifier,
                this.name,
                this.ects,
                this.startingYear,
                this.semester
            )
        }
    }
}

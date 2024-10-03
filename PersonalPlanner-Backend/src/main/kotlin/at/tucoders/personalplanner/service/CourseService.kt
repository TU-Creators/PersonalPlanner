package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.CourseDto
import at.tucoders.personalplanner.mapper.CourseMapper.Companion.toDto
import at.tucoders.personalplanner.persistance.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val courseRepository: CourseRepository
) {
    fun findAll(): List<CourseDto> {
        return courseRepository.findAll().map { it.toDto() }
    }
}

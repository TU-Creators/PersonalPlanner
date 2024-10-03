package at.tucoders.personalplanner.controller

import at.tucoders.personalplanner.controller.dto.CourseDto
import at.tucoders.personalplanner.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/course")
class CourseController(
    val courseService: CourseService
) {

    @GetMapping
    fun getCourses(): List<CourseDto> {
        return courseService.findAll()
    }

}

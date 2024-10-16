package at.tucoders.personalplanner.controller

import at.tucoders.personalplanner.controller.dto.AcademicProgramDto
import at.tucoders.personalplanner.service.AcademicProgramService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("v1/academic-program")
class AcademicProgramController(
    val service: AcademicProgramService
) {
    @GetMapping
    fun findAllPrograms(): List<AcademicProgramDto> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findProgramById(@PathVariable("id") id: UUID): AcademicProgramDto {
        return service.findById(id)
    }

    @PostMapping
    fun createProgram(@RequestBody academicProgramDto: AcademicProgramDto): AcademicProgramDto {
        return service.create(academicProgramDto)
    }

    @PutMapping
    fun updateProgram(@RequestBody academicProgramDto: AcademicProgramDto): AcademicProgramDto {
        return service.update(academicProgramDto)
    }

    @DeleteMapping("/{id}")
    fun deleteProgram(@PathVariable("id") id: UUID): AcademicProgramDto {
        return service.delete(id)
    }
}

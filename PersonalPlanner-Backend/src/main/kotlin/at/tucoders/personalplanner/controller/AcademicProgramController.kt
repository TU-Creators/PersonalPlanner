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
    fun findAll(): List<AcademicProgramDto> {
        return service.findAll()
    }

    @GetMapping("/{id}")
    fun findAll(@PathVariable("id") id: UUID): AcademicProgramDto {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody academicProgramDto: AcademicProgramDto): AcademicProgramDto {
        return service.create(academicProgramDto)
    }

    @PutMapping
    fun update(@RequestBody academicProgramDto: AcademicProgramDto) {
        service.update(academicProgramDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: UUID) {
        service.delete(id)
    }
}

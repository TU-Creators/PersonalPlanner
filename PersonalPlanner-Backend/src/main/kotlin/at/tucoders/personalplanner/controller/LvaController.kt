package at.tucoders.personalplanner.controller

import at.tucoders.personalplanner.controller.dto.LvaDto
import at.tucoders.personalplanner.service.LvaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/lva")
class LvaController(
    val lvaService: LvaService
) {

    @GetMapping
    fun getCourses(): List<LvaDto> {
        return lvaService.findAll()
    }

}

package at.tucoders.personalplanner.controller

import at.tucoders.personalplanner.controller.dto.UserDto
import at.tucoders.personalplanner.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/user")
class UserController(
    val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<UserDto> {
        return userService.findAll()
    }

}

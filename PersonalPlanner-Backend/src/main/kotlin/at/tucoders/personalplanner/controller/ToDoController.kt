package at.tucoders.personalplanner.controller

import at.tucoders.personalplanner.controller.dto.ToDoDto
import at.tucoders.personalplanner.service.ToDoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("v1/todo")
class ToDoController(
    val toDoService: ToDoService
) {

    @GetMapping
    fun getTodos(): List<ToDoDto> {
        return toDoService.getTodos()
    }

    @PostMapping
    fun createTodo(@RequestBody toDo: ToDoDto): ToDoDto {
        if(toDo.id != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Id must be null")
        }
        return toDoService.createTodo(toDo)
    }

    @DeleteMapping
    fun deleteTodo(@RequestParam("id") id: UUID) {
        toDoService.deleteTodo(id)
    }

}

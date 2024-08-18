package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.ToDoDto
import at.tucoders.personalplanner.persistance.ToDoEntryRepository
import at.tucoders.personalplanner.persistance.entity.ToDoEntryEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ToDoService(
    val toDoEntryRepository: ToDoEntryRepository
) {

    fun getTodos(): List<ToDoDto> {
        return toDoEntryRepository.findAll().map { it.toDto() }
    }

    fun createTodo(toDo: ToDoDto): ToDoDto {
        val newToDo = toDoEntryRepository.save(toDo.toEntity())
        return newToDo.toDto()
    }

    fun deleteTodo(id: UUID) {
        toDoEntryRepository.deleteById(id)
    }

    private fun ToDoEntryEntity.toDto(): ToDoDto {
        return ToDoDto(this.id, this.text)
    }

    private fun ToDoDto.toEntity(): ToDoEntryEntity {
        return ToDoEntryEntity(this.id, this.text)
    }

}

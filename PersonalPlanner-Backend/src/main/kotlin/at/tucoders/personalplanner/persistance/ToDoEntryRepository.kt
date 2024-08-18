package at.tucoders.personalplanner.persistance

import at.tucoders.personalplanner.persistance.entity.ToDoEntryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ToDoEntryRepository: JpaRepository<ToDoEntryEntity, UUID> {
}

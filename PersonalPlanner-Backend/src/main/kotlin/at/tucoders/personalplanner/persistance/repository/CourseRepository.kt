package at.tucoders.personalplanner.persistance.repository

import at.tucoders.personalplanner.persistance.CourseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourseRepository: JpaRepository<CourseEntity, UUID> {
}

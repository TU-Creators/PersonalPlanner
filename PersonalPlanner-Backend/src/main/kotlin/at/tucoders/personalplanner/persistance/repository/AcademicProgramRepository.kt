package at.tucoders.personalplanner.persistance.repository

import at.tucoders.personalplanner.persistance.AcademicProgramEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AcademicProgramRepository: JpaRepository<AcademicProgramEntity, UUID> {
}

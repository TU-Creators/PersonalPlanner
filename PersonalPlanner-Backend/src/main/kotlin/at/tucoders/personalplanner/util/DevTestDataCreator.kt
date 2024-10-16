package at.tucoders.personalplanner.util

import at.tucoders.personalplanner.persistance.AcademicProgramEntity
import at.tucoders.personalplanner.persistance.CourseEntity
import at.tucoders.personalplanner.persistance.UserEntity
import at.tucoders.personalplanner.persistance.repository.AcademicProgramRepository
import at.tucoders.personalplanner.persistance.repository.CourseRepository
import at.tucoders.personalplanner.persistance.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("dev")
class DevTestDataCreator(
    private val userRepository: UserRepository,
    private val academicProgramRepository: AcademicProgramRepository,
    private val courseRepository: CourseRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val user = UserEntity(
            null,
            "userid",
            "username",
            "useremail",
            emptySet()
        )

        userRepository.saveAndFlush(user)

        val program = AcademicProgramEntity(
            null,
            null,
            "Informatik",
            2022,
            Semester.WINTER,
            180,
            user,
            setOf()
        )

        academicProgramRepository.saveAndFlush(program)

        val lva = CourseEntity(
            null,
            null,
            "ADM",
            9,
            2022,
            Semester.WINTER,
            program
        )

        courseRepository.saveAndFlush(lva)
    }
}

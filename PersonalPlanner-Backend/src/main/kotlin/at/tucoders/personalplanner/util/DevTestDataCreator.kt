package at.tucoders.personalplanner.util

import at.tucoders.personalplanner.persistance.CourseEntity
import at.tucoders.personalplanner.persistance.LvaEntity
import at.tucoders.personalplanner.persistance.UserEntity
import at.tucoders.personalplanner.persistance.repository.CourseRepository
import at.tucoders.personalplanner.persistance.repository.LvaRepository
import at.tucoders.personalplanner.persistance.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("dev")
class DevTestDataCreator(
    private val userRepository: UserRepository,
    private val courseRepository: CourseRepository,
    private val lvaRepository: LvaRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val user = UserEntity(
            null,
            "username",
            "firstname",
            "lastname",
            emptySet()
        )

        userRepository.saveAndFlush(user)

        val course = CourseEntity(
            null,
            "Informatik",
            2022,
            Semester.WINTER,
            180,
            user,
            setOf()
        )

        courseRepository.saveAndFlush(course)

        val lva = LvaEntity(
            null,
            "ADM",
            9,
            course
        )

        lvaRepository.saveAndFlush(lva)
    }
}

package at.tucoders.personalplanner.persistance

import at.tucoders.personalplanner.util.Semester
import jakarta.persistence.*
import java.util.*

@Entity(name = "course")
class CourseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column
    var identifier: String? = null,
    @Column(nullable = false)
    var name: String,
    @Column
    var ects: Int? = null,
    @Column(nullable = false)
    var startingYear: Int,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var semester: Semester,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", nullable = false)
    val program: AcademicProgramEntity
){
}

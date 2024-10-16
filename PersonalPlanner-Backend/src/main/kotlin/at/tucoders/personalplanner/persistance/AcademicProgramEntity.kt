package at.tucoders.personalplanner.persistance

import at.tucoders.personalplanner.util.Semester
import jakarta.persistence.*
import java.util.*

@Entity(name = "academic_program")
class AcademicProgramEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column
    var identifier: String? = null,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    var startingYear: Int,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var startingSemester: Semester,
    @Column
    var requiredEcts: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    val user: UserEntity,

    @OneToMany(mappedBy = "program")
    val courses: Set<CourseEntity>
) {
}

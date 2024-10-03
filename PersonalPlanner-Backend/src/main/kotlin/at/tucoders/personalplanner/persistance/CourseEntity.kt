package at.tucoders.personalplanner.persistance

import at.tucoders.personalplanner.util.Semester
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.util.*

@Entity(name = "course")
class CourseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
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

    @OneToMany(mappedBy = "course")
    val lvas: Set<LvaEntity>
) {
}

package at.tucoders.personalplanner.persistance

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.*

@Entity(name = "usertable")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    @Column(nullable = false, unique = true)
    var userId: String,
    @Column
    var name: String?,
    @Column
    var email: String?,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    val programs: Set<AcademicProgramEntity>
) {
}

package at.tucoders.personalplanner.controller.dto

import at.tucoders.personalplanner.util.Semester
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class CourseDto(
    @JsonProperty("id")
    val id: UUID?,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("startingYear")
    val startingYear: Int,
    @JsonProperty("startingSemester")
    val startingSemester: Semester,
    @JsonProperty("requiredEcts")
    val requiredEcts: Int?
)

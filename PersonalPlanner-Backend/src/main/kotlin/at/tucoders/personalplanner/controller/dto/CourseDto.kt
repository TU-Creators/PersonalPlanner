package at.tucoders.personalplanner.controller.dto

import at.tucoders.personalplanner.util.Semester
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class CourseDto(
    @JsonProperty("id")
    val id: UUID?,
    @JsonProperty("identifier")
    val identifier: String?,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("ects")
    val ects: Int?,
    @JsonProperty("startingYear")
    val startingYear: Int,
    @JsonProperty("semester")
    val semester: Semester,
)

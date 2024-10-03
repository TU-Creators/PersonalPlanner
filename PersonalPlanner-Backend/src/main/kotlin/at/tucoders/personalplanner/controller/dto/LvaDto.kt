package at.tucoders.personalplanner.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class LvaDto(
    @JsonProperty("id")
    val id: UUID?,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("ects")
    val ects: Int?
)

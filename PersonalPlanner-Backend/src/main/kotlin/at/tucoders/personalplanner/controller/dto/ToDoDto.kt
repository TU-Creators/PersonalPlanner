package at.tucoders.personalplanner.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class ToDoDto(
    @JsonProperty("id")
    val id: UUID?,
    @JsonProperty("text")
    val text: String
)

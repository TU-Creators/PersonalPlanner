package at.tucoders.personalplanner.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class UserDto(
    @JsonProperty("id")
    val id: UUID?,
    @JsonProperty("username")
    val username: String,
    @JsonProperty("firstname")
    val firstname: String,
    @JsonProperty("lastname")
    val lastname: String
)

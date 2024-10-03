package at.tucoders.personalplanner.mapper

import at.tucoders.personalplanner.controller.dto.LvaDto
import at.tucoders.personalplanner.persistance.LvaEntity

class LvaMapper {
    companion object {
        fun LvaEntity.toDto(): LvaDto {
            return LvaDto(
                this.id,
                this.name,
                this.ects
            )
        }
    }
}

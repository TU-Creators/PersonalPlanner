package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.LvaDto
import at.tucoders.personalplanner.mapper.LvaMapper.Companion.toDto
import at.tucoders.personalplanner.persistance.repository.LvaRepository
import org.springframework.stereotype.Service

@Service
class LvaService(
    private val lvaRepository: LvaRepository
) {
    fun findAll(): List<LvaDto> {
        return lvaRepository.findAll().map { it.toDto() }
    }
}

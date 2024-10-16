package at.tucoders.personalplanner.service

import at.tucoders.personalplanner.controller.dto.AcademicProgramDto
import at.tucoders.personalplanner.exception.MappedBadRequestException
import at.tucoders.personalplanner.exception.MappedNotFoundException
import at.tucoders.personalplanner.mapper.AcademicProgramMapper.Companion.toDto
import at.tucoders.personalplanner.mapper.AcademicProgramMapper.Companion.toEntity
import at.tucoders.personalplanner.mapper.AcademicProgramMapper.Companion.updateFromDto
import at.tucoders.personalplanner.persistance.AcademicProgramEntity
import at.tucoders.personalplanner.persistance.repository.AcademicProgramRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AcademicProgramService(
    private val userService: UserService,
    private val academicProgramRepository: AcademicProgramRepository
) {
    fun findAll(): List<AcademicProgramDto> {
        return userService.findOrCreateCurrentUserEntity().programs.map { it.toDto() }
    }

    fun findById(id: UUID): AcademicProgramDto {
        return findAcademicProgramById(id).toDto()
    }

    fun create(academicProgram: AcademicProgramDto): AcademicProgramDto {
        if(academicProgram.id != null) {
            throw MappedBadRequestException("ID value has to be null!")
        }

        val userEntity = userService.findOrCreateCurrentUserEntity()

        val programEntity = academicProgram.toEntity(userEntity, emptySet())

        academicProgramRepository.saveAndFlush(programEntity)

        return programEntity.toDto()
    }

    fun update(academicProgram: AcademicProgramDto): AcademicProgramDto {
        val programEntity = findAcademicProgramById(academicProgram.id)

        programEntity.updateFromDto(academicProgram)
        academicProgramRepository.saveAndFlush(programEntity)

        return programEntity.toDto()
    }

    fun delete(academicProgramId: UUID): AcademicProgramDto {
        val programEntity = findAcademicProgramById(academicProgramId)

        academicProgramRepository.delete(programEntity)
        academicProgramRepository.flush()

        return programEntity.toDto()
    }

    private fun findAcademicProgramById(id: UUID?): AcademicProgramEntity {
        if(id == null) {
            throw MappedBadRequestException("ID value has to be not null!")
        }

        val programEntity = userService.findOrCreateCurrentUserEntity().programs.find { it.id == id }

        if(programEntity == null) {
            throw MappedNotFoundException("Academic program with ID $id not found!")
        }

        return programEntity
    }
}

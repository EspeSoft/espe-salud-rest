package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.RecordLaboral;
import com.espe.salud.dto.paciente.RecordLaboralDTO;
import com.espe.salud.mapper.paciente.RecordLaboralMapper;
import com.espe.salud.persistence.paciente.RecordLaboralRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecordLaboralServicelmpl implements RecordLaboralService {
    private final RecordLaboralRepository recordLaboralRepository;
    private final RecordLaboralMapper mapper;

    public RecordLaboralServicelmpl(RecordLaboralRepository recordLaboralRepository, RecordLaboralMapper mapper) {
        this.recordLaboralRepository = recordLaboralRepository;
        this.mapper = mapper;
    }

    @Override
    public RecordLaboralDTO save(RecordLaboralDTO recordLaboral) {
        Optional<RecordLaboral> optional = findExisting(recordLaboral);
        if (!optional.isPresent()) {
            RecordLaboral domainObject = toEntity(recordLaboral);
            return toDTO(recordLaboralRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un empleado registrada para ese código[%s]", recordLaboral.getId()));
        }
    }

    @Override
    public Optional<RecordLaboral> findExisting(RecordLaboralDTO recordLaboralDTO) {
        return recordLaboralRepository.findByCodigo(recordLaboralDTO.getId());
    }

    @Override
    public Optional<RecordLaboralDTO> findById(Long codigo) {
        return Optional.empty();
    }

    @Override
    public RecordLaboralDTO toDTO(RecordLaboral recordLaboral) {
        return mapper.toRecordLaboralDTO(recordLaboral);
    }

    @Override
    public RecordLaboral toEntity(RecordLaboralDTO dto) {
        return mapper.toRecordLaboral(dto);
    }
}

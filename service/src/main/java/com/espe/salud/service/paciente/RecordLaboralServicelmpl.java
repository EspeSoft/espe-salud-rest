package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.RecordLaboral;
import com.espe.salud.dto.paciente.RecordLaboralDTO;
import com.espe.salud.mapper.paciente.RecordLaboralMapper;
import com.espe.salud.persistence.paciente.RecordLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordLaboralServicelmpl implements RecordLaboralService {
    private final RecordLaboralRepository recordLaboralRepository;
    private final RecordLaboralMapper mapper;

    @Autowired
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
    public RecordLaboralDTO update(RecordLaboralDTO recordLaboral) {
        RecordLaboral domainObject = toEntity(recordLaboral);
        return toDTO(recordLaboralRepository.save(domainObject));
    }

    @Override
    public Optional<RecordLaboral> findExisting(RecordLaboralDTO recordLaboralDTO) {
        return recordLaboralRepository.findByCodigo(recordLaboralDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return recordLaboralRepository.findById(id).map(object -> {
            recordLaboralRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<RecordLaboralDTO> findByCodigo(Long codigo) {
        return recordLaboralRepository.findByCodigo(codigo).map(recordLaboral -> mapper.toRecordLaboralDTO(recordLaboral));
    }


    @Override
    public RecordLaboralDTO toDTO(RecordLaboral recordLaboral) {
        return mapper.toRecordLaboralDTO(recordLaboral);
    }

    @Override
    public RecordLaboral toEntity(RecordLaboralDTO dto) {
        return mapper.toRecordLaboral(dto);
    }

    @Override
    public List<RecordLaboralDTO> findAll() {
        List<RecordLaboral> recordLaborals = new ArrayList<>();
        recordLaboralRepository.findAll().forEach(recordLaborals::add);
        return mapper.toRecordLaboralesDTO(recordLaborals);
    }
}

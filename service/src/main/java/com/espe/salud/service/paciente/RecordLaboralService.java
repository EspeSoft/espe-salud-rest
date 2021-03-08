package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.RecordLaboral;
import com.espe.salud.dto.paciente.RecordLaboralDTO;

import java.util.List;
import java.util.Optional;

public interface RecordLaboralService {

    RecordLaboralDTO save(RecordLaboralDTO recordLaboral);

    RecordLaboralDTO update(RecordLaboralDTO recordLaboral);

    Optional<RecordLaboral> findExisting(RecordLaboralDTO recordLaboralDTO);

    Boolean delete(Long id);

    Optional<RecordLaboralDTO> findByCodigo(Long codigo);

    RecordLaboralDTO toDTO(RecordLaboral recordLaboral);

    RecordLaboral toEntity(RecordLaboralDTO dto);

    List<RecordLaboralDTO> findAll();
}

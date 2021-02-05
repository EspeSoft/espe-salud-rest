package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.RecordLaboral;
import com.espe.salud.dto.paciente.RecordLaboralDTO;

import java.util.Optional;
public interface RecordLaboralService {

    RecordLaboralDTO save(RecordLaboralDTO recordLaboral);
    Optional<RecordLaboral> findExisting(RecordLaboralDTO recordLaboralDTO);
    Optional<RecordLaboralDTO> findById(Long codigo);
    RecordLaboralDTO toDTO( RecordLaboral recordLaboral);
    RecordLaboral toEntity(RecordLaboralDTO dto);
}

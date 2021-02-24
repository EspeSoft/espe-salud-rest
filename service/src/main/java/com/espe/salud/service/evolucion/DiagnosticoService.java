package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoService {
    DiagnosticoDTO save  (DiagnosticoDTO diagnosticoDTO);
    DiagnosticoDTO update(DiagnosticoDTO diagnosticoDTO);
    Optional<Diagnostico> findExisting(DiagnosticoDTO diagnosticoDTO);
    Boolean delete(Long id);
    Optional<DiagnosticoDTO > findById(Long codigo);
    DiagnosticoDTO  toDTO (Diagnostico diagnostico);
    Diagnostico toEntity (DiagnosticoDTO dto);
    List<DiagnosticoDTO> findAll();
}

package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;

import java.util.Optional;

public interface DiagnosticoService {
    DiagnosticoDTO save  (DiagnosticoDTO diagnostico);
    Optional<Diagnostico> findExisting(DiagnosticoDTO diagnosticoDTO);
    Optional<DiagnosticoDTO > findById(Long codigo);
    DiagnosticoDTO  toDTO (Diagnostico diagnostico);
    Diagnostico toEntity (DiagnosticoDTO dto);
}

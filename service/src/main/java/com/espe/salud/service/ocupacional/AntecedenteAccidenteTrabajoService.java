package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;

import java.util.Optional;

public interface AntecedenteAccidenteTrabajoService {
    AntecedenteEmpleoAnteriorDTO save  (AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnterior);
    AntecedenteEmpleoAnteriorDTO update(AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnterior);
    Boolean delete(Long id);
    Optional<AntecedenteEmpleoAnterior> findExisting(AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnteriorDTO);
    Optional<AntecedenteEmpleoAnteriorDTO > findById(Long codigo);
    AntecedenteEmpleoAnteriorDTO  toDTO (AntecedenteEmpleoAnterior antecedenteEmpleoAnterior);
    AntecedenteEmpleoAnterior toEntity (AntecedenteEmpleoAnteriorDTO dto);
}

package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;

import java.util.Optional;

public interface AntecedenteEmpleoAnteriorService {
    AntecedenteEmpleoAnteriorDTO save  (AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnterior);
    Optional<AntecedenteEmpleoAnterior> findExisting(AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnteriorDTO);
    Optional<AntecedenteEmpleoAnteriorDTO > findById(Long codigo);
    AntecedenteEmpleoAnteriorDTO  toDTO (AntecedenteEmpleoAnterior antecedenteEmpleoAnterior);
    AntecedenteEmpleoAnterior toEntity (AntecedenteEmpleoAnteriorDTO dto);
}

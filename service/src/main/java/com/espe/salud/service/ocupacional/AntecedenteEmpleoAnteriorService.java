package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteEmpleoAnteriorService {
    AntecedenteEmpleoAnteriorDTO save  (AntecedenteEmpleoAnteriorDTO antecedente);
    AntecedenteEmpleoAnteriorDTO update(AntecedenteEmpleoAnteriorDTO antecedente);
    Boolean delete(Long id);
    Optional<AntecedenteEmpleoAnteriorDTO > findByCodigo(Long codigo);
    List<AntecedenteEmpleoAnteriorDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral);
    AntecedenteEmpleoAnteriorDTO  toDTO (AntecedenteEmpleoAnterior antecedente);
    AntecedenteEmpleoAnterior toEntity (AntecedenteEmpleoAnteriorDTO dto);
}

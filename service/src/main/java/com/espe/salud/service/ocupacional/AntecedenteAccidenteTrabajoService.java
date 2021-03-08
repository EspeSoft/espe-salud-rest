package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteAccidenteTrabajoService {
    AntecedenteAccidenteTrabajoDTO save(AntecedenteAccidenteTrabajoDTO antecedente);

    AntecedenteAccidenteTrabajoDTO update(AntecedenteAccidenteTrabajoDTO antecedente);

    Boolean delete(Long id);

    Optional<AntecedenteAccidenteTrabajoDTO> findByCodigo(Long codigo);

    List<AntecedenteAccidenteTrabajoDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral);

    AntecedenteAccidenteTrabajoDTO toDTO(AntecedenteAccidenteTrabajo antecedente);

    AntecedenteAccidenteTrabajo toEntity(AntecedenteAccidenteTrabajoDTO dto);
}

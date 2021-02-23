package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteAccidenteTrabajoService {
    AntecedenteAccidenteTrabajoDTO save  (AntecedenteAccidenteTrabajoDTO antecedente);
    AntecedenteAccidenteTrabajoDTO update(AntecedenteAccidenteTrabajoDTO antecedente);
    Optional<AntecedenteAccidenteTrabajo> findExisting(AntecedenteAccidenteTrabajoDTO antecedenteDTO);
    Boolean delete(Long id);
    Optional<AntecedenteAccidenteTrabajoDTO > findByCodigo(Long codigo);
    AntecedenteAccidenteTrabajoDTO  toDTO (AntecedenteAccidenteTrabajo antecedente);
    AntecedenteAccidenteTrabajo toEntity (AntecedenteAccidenteTrabajoDTO dto);
    List<AntecedenteAccidenteTrabajoDTO> findAll();
}

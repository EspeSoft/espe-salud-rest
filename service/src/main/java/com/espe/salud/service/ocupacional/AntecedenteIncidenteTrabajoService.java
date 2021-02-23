package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteIncidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteIncidenteTrabajoService {
    AntecedenteIncidenteTrabajoDTO save  (AntecedenteIncidenteTrabajoDTO antecedente);
    AntecedenteIncidenteTrabajoDTO update(AntecedenteIncidenteTrabajoDTO antecedente);
    Optional<AntecedenteIncidenteTrabajo> findExisting(AntecedenteIncidenteTrabajoDTO antecedenteDTO);
    Boolean delete(Long id);
    Optional<AntecedenteIncidenteTrabajoDTO > findByCodigo(Long codigo);
    AntecedenteIncidenteTrabajoDTO  toDTO (AntecedenteIncidenteTrabajo antecedente);
    AntecedenteIncidenteTrabajo toEntity (AntecedenteIncidenteTrabajoDTO dto);
    List<AntecedenteIncidenteTrabajoDTO> findAll();
}

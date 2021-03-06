package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;

import java.util.List;
import java.util.Optional;

public interface FactorRiesgoPuestoActualService {
    FactorRiesgoPuestoActualDTO save(FactorRiesgoPuestoActualDTO factor);

    FactorRiesgoPuestoActualDTO update(FactorRiesgoPuestoActualDTO factor);

    Boolean delete(Long id);

    Optional<FactorRiesgoPuestoActualDTO> findByCodigo(Long codigo);

    List<FactorRiesgoPuestoActualDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral);

    FactorRiesgoPuestoActualDTO toDTO(FactorRiesgoPuestoActual factor);

    FactorRiesgoPuestoActual toEntity(FactorRiesgoPuestoActualDTO dto);
}

package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PlanificacionFamiliarService {

    PlanificacionFamiliarDTO save(PlanificacionFamiliarDTO planificacionFamiliarDTO);

    PlanificacionFamiliarDTO update(PlanificacionFamiliarDTO planificacionFamiliarDTO);

    Optional<PlanificacionFamiliarDTO> findById(Long codigo);

    List<PlanificacionFamiliarDTO> findAll();

    boolean deleteById(Long id);

    PlanificacionFamiliarDTO toDTO(PlanificacionFamiliar planificacionFamiliar);

    PlanificacionFamiliar toEntity(PlanificacionFamiliarDTO dto);

}

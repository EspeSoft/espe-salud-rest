package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;

import java.util.List;
import java.util.Optional;

public interface PlanificacionFamiliarService {

    PlanificacionFamiliarDTO save(PlanificacionFamiliarDTO dto);

    PlanificacionFamiliarDTO update(PlanificacionFamiliarDTO dto);

    Optional<PlanificacionFamiliarDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<PlanificacionFamiliarDTO> findByPaciente(Long idPaciente);

}

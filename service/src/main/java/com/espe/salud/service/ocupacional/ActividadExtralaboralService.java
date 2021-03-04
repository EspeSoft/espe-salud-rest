package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadExtralaboralService {
    ActividadExtralaboralDTO save(ActividadExtralaboralDTO actividad);

    ActividadExtralaboralDTO update(ActividadExtralaboralDTO actividad);

    Boolean delete(Long id);

    Optional<ActividadExtralaboralDTO> findByCodigo(Long codigo);

    List<ActividadExtralaboralDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral);

    ActividadExtralaboralDTO toDTO(ActividadExtralaboral actividad);

    ActividadExtralaboral toEntity(ActividadExtralaboralDTO dto);
}

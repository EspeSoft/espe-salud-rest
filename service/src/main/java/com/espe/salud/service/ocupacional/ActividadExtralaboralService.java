package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.ActividadExtralaboral;
import com.espe.salud.dto.ocupacional.ActividadExtralaboralDTO;

import java.util.List;
import java.util.Optional;

public interface ActividadExtralaboralService {
    ActividadExtralaboralDTO save  (ActividadExtralaboralDTO actividad);
    ActividadExtralaboralDTO update(ActividadExtralaboralDTO actividad);
    Optional<ActividadExtralaboral> findExisting(ActividadExtralaboralDTO actividadDTO);
    Boolean delete(Long id);
    Optional<ActividadExtralaboralDTO > findByCodigo(Long codigo);
    ActividadExtralaboralDTO  toDTO (ActividadExtralaboral actividad);
    ActividadExtralaboral toEntity (ActividadExtralaboralDTO dto);
    List<ActividadExtralaboralDTO> findAll();
}

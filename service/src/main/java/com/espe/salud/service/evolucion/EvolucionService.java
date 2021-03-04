package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;

import java.util.List;
import java.util.Optional;

public interface EvolucionService {
    EvolucionDTO save(EvolucionDTO evolucion);

   EvolucionDTO toDTO(Evolucion evolucion);
   Evolucion toEntity(EvolucionDTO dto);
   Boolean delete(String id);
   EvolucionDTO update(EvolucionDTO dto);
   Optional<EvolucionDTO> findById(String id);
   List<EvolucionDTO> findByUsuario(Long pidm);
   List<EvolucionDTO> findByPaciente(Long id);
}

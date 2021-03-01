package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;

import java.util.Optional;

public interface EvolucionService {
   EvolucionDTO save(EvolucionDTO evolucion);
   Optional<Evolucion> findExisting(EvolucionDTO evolucionDTO);

   EvolucionDTO toDTO(Evolucion evolucion);
   Evolucion toEntity(EvolucionDTO dto);

   byte[] getCertificadoMedico(String idEvolucion);
}

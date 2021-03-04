package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Prescripcion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.evolucion.PrescripcionDTO;

import java.util.List;
import java.util.Optional;

public interface PrescripcionService {
    PrescripcionDTO save(PrescripcionDTO dto);
    Optional<Prescripcion> findExisting(PrescripcionDTO dto);
    PrescripcionDTO toDTO(Prescripcion prescripcion);
    Prescripcion toEntity(PrescripcionDTO dto);
    Boolean delete(Long id);
    PrescripcionDTO update(PrescripcionDTO dto);
    Optional<PrescripcionDTO> findById(Long id);
    List<PrescripcionDTO> findByEvolucion(String id);
}

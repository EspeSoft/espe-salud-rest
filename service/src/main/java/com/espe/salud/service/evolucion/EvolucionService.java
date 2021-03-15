package com.espe.salud.service.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.evolucion.ReposoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EvolucionService {
   EvolucionDTO save(EvolucionDTO evolucion);
   Optional<Evolucion> findExisting(EvolucionDTO evolucionDTO);
   EvolucionDTO toDTO(Evolucion evolucion);
   Evolucion toEntity(EvolucionDTO dto);
   Boolean delete(String id);
   EvolucionDTO update(EvolucionDTO dto);
   Optional<EvolucionDTO> findById(String id);
   List<EvolucionDTO> findByUsuario(Long pidm);
   List<EvolucionDTO> findByPaciente(Long id);
   byte[] getCertificadoMedico(String idEvolucion);
   byte[] getRecetaMedica(String idEvolucion);
   byte[] getCertificadoReposo(String fechaInicio, String fechaFin, String condicionPaciente, String recomrndacion, String idEvolucion);
}

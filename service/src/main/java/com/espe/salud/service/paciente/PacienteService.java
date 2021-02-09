package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.paciente.PacienteBannerDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.dto.paciente.PacienteExternoDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    PacienteDTO saveExternal(PacienteExternoDTO paciente);
    PacienteDTO saveBanner(PacienteBannerDTO pacienteBannerDTO);
//    PacienteDTO update(PacienteDTO paciente);
    Optional<Paciente> findExistingByNumeroArchivo(String numeroArchivo);
//    Boolean delete(Long id);
//    Optional<PacienteDTO> findByCodigo(Long codigo);
    List<PacienteDTO> findAll();
}

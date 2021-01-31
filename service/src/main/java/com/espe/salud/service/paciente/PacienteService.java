package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import com.espe.salud.dto.paciente.PacienteDTO;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    PacienteDTO save(PacienteDTO paciente);
    Optional<Paciente> findExisting(PacienteDTO pacienteDTO);
    Boolean delete(Long id);
    List<PacienteDTO> findByCodigo(Long codigo);
    PacienteDTO toDTO(Paciente paciente);
    Paciente toEntity(PacienteDTO dto);
    List<PacienteDTO> findAll();

}

package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.paciente.PersonaDTO;

import java.util.Optional;

public interface PersonaService {
    PersonaDTO save(PersonaDTO paciente);
    Optional<Persona> findExisting(PersonaDTO pacienteDTO);

    PersonaDTO toDTO(Persona paciente);
    Persona toEntity(PersonaDTO dto);
}

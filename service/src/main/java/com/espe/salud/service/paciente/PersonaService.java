package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.Persona;

import java.util.Optional;

public interface PersonaService {
    Optional<Persona> findByIdPaciente(Long idPaciente);
}

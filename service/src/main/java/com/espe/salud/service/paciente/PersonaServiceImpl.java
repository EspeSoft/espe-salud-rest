package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.paciente.PersonaDTO;
import com.espe.salud.mapper.paciente.PersonaMapper;
import com.espe.salud.persistence.paciente.PersonaRepository;

import java.util.Optional;

public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository personaRepository;
    private final PersonaMapper mapper;

    public PersonaServiceImpl(PersonaRepository personaRepository, PersonaMapper mapper) {
        this.personaRepository = personaRepository;
        this.mapper = mapper;
    }

    @Override
    public PersonaDTO save(PersonaDTO paciente) {
        return null;
    }

    @Override
    public Optional<Persona> findExisting(PersonaDTO pacienteDTO) {
        return Optional.empty();
    }

    @Override
    public PersonaDTO toDTO(Persona paciente) {
        return null;
    }

    @Override
    public Persona toEntity(PersonaDTO dto) {
        return null;
    }
}

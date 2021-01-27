package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
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
    public PersonaDTO save(PersonaDTO persona) {
        Optional<Persona> optional = findExisting(persona);
        if (!optional.isPresent()) {
            Persona domainObject = toEntity(persona);
            return toDTO(personaRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", persona.getId()));
        }
    }

    @Override
    public Optional<Persona> findExisting(PersonaDTO personaDTO) {
        return personaRepository.findByCodigo(personaDTO.getId());
    }

    @Override
    public PersonaDTO toDTO(Persona persona) {
        return mapper.toPersonaDTO(persona);
    }

    @Override
    public Persona toEntity(PersonaDTO dto) {
        return mapper.toPersona(dto);
    }
}

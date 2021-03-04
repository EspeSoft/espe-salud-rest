package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.ContactoEmergencia;
import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.dto.paciente.ContactoEmergenciaDTO;
import com.espe.salud.mapper.paciente.ContactoEmergenciaMapper;
import com.espe.salud.persistence.paciente.ContactoEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoEmergenciaServiceImpl implements ContactoEmergenciaService{

    private final ContactoEmergenciaRepository repository;
    private final ContactoEmergenciaMapper mapper;
    private final PersonaService personaService;

    @Autowired
    public ContactoEmergenciaServiceImpl(
            ContactoEmergenciaRepository repository,
            ContactoEmergenciaMapper mapper, PersonaService personaService) {
        this.repository = repository;
        this.mapper = mapper;
        this.personaService = personaService;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<ContactoEmergenciaDTO> findById(Long id) {
        return repository.findByCodigo(id).map(mapper::toContactoEmergenciaDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactoEmergenciaDTO> findByPaciente(Long idPaciente) {
        return mapper.toContactosEmergenciaDTO(repository.findByPersonaPacienteCodigo(idPaciente));
    }

    @Override
    @Transactional
    public ContactoEmergenciaDTO save(ContactoEmergenciaDTO dto, Long idPaciente) {
        Optional<Persona> personaOptional = personaService.findByIdPaciente(idPaciente);
        if (personaOptional.isEmpty()) {
            throw new EntityNotFoundException("No se ha encontrado un paciente para ese ID");
        }
        Optional<ContactoEmergencia> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            ContactoEmergencia domainObject = mapper.toContactoEmergencia(dto);
            domainObject.setPersona(personaOptional.get());
            return mapper.toContactoEmergenciaDTO(repository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe un contacto de emergencia registrado con ese id");
        }
    }

    @Override
    @Transactional
    public ContactoEmergenciaDTO update(ContactoEmergenciaDTO dto, Long idPaciente) {
        ContactoEmergencia domainObject = mapper.toContactoEmergencia(dto);
        Optional<Persona> personaOptional = personaService.findByIdPaciente(idPaciente);
        if (personaOptional.isEmpty()) {
            throw new EntityNotFoundException("No se ha encontrado un paciente para ese ID");
        }
        domainObject.setPersona(domainObject.getPersona());
        return mapper.toContactoEmergenciaDTO(repository.save(domainObject));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);    }
}

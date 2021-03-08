package com.espe.salud.service.paciente;

import com.espe.salud.domain.entities.paciente.Persona;
import com.espe.salud.persistence.paciente.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository repository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Persona> findByIdPaciente(Long idPaciente) {
        return repository.findByPacienteCodigo(idPaciente);
    }
}

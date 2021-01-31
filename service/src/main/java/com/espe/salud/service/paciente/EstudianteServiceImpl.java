package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.dto.paciente.EstudianteDTO;
import com.espe.salud.mapper.paciente.EstudianteMapper;
import com.espe.salud.persistence.paciente.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService{
    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper mapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository, EstudianteMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

    @Override
    public EstudianteDTO save(EstudianteDTO estudiante) {
        Optional<Estudiante> optional = findExisting(estudiante);
        if (!optional.isPresent()) {
            Estudiante domainObject = toEntity(estudiante);
            return toDTO(estudianteRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un empleado registrada para ese código[%s]", estudiante.getId()));
        }
    }

    @Override
    public Optional<Estudiante> findExisting(EstudianteDTO estudianteDTO) {
        return estudianteRepository.findByCodigo(estudianteDTO.getId());
    }

    @Override
    public Optional<EstudianteDTO> findById(Long codigo) {
        return Optional.empty();
    }


    @Override
    public EstudianteDTO toDTO(Estudiante estudiante) {
        return mapper.toEstudianteDTO(estudiante);
    }

    @Override
    public Estudiante toEntity(EstudianteDTO dto) {
        return mapper.toEstudiante(dto);
    }
}

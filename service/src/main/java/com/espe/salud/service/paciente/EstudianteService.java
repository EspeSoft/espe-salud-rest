package com.espe.salud.service.paciente;



import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.dto.paciente.EstudianteDTO;

import java.util.Optional;

public interface EstudianteService {
    EstudianteDTO save(EstudianteDTO estudiante);
    Optional<Estudiante> findExisting(EstudianteDTO estudianteDTO);
    Optional<EstudianteDTO> findById(Long codigo);
    EstudianteDTO toDTO(Estudiante estudiante);
    Estudiante toEntity(EstudianteDTO dto);
}

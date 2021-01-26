package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.EstudianteDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EstudianteDTO toEstudianteDTO(Estudiante estudiante);

    List<EstudianteDTO> toEstudiantesDTO(List<Estudiante> estudiantes);

    @InheritInverseConfiguration
    Estudiante toEstudiante(EstudianteDTO dto);
}

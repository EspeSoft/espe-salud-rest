package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.paciente.EstudianteDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    @Mapping(source = "codigo", target = "id")
    @Mapping(source = "fechaIngresoEspe", target = "fechaIngresoEspe", qualifiedByName = "generateFechaIngresoEspeDateTime")
    EstudianteDTO toEstudianteDTO(Estudiante estudiante);

    @Named("generateFechaIngresoEspeDateTime")
    static LocalDateTime generateFechaIngresoEspeDateTime(LocalDate fechaIngresoEspe) {
        return fechaIngresoEspe.atStartOfDay();
    }

    List<EstudianteDTO> toEstudiantesDTO(List<Estudiante> estudiantes);

    @InheritInverseConfiguration
    @Mapping(source = "fechaIngresoEspe", target = "fechaIngresoEspe", qualifiedByName = "generateFechaIngresoEspeDate")
    Estudiante toEstudiante(EstudianteDTO dto);

    @Named("generateFechaIngresoEspeDate")
    static LocalDate generateFechaIngresoEspeDate(LocalDateTime fechaIngresoEspe) {
        return fechaIngresoEspe.toLocalDate();
    }
}

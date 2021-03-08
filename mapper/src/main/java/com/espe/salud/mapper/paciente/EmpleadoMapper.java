package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Empleado;
import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.dto.paciente.EmpleadoDTO;
import com.espe.salud.dto.paciente.EstudianteDTO;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    @Mapping(source = "codigo", target = "id")
    @Mapping(source = "fechaIngresoLaboral", target = "fechaIngresoLaboral", qualifiedByName = "generateFechaIngresoLaboralDateTime")
    EmpleadoDTO toEmpleadoDTO(Empleado empleado);

    @Named("generateFechaIngresoLaboralDateTime")
    static LocalDateTime generateFechaIngresoLaboralDateTime(LocalDate fechaIngresoLaboral) {
        return fechaIngresoLaboral.atStartOfDay();
    }

    List<EmpleadoDTO> toEmpleadosDTO(List<Empleado> empleados);

    @InheritInverseConfiguration
    @Mapping(source = "fechaIngresoLaboral", target = "fechaIngresoLaboral", qualifiedByName = "generateFechaIngresoLaboralDate")
    Empleado toEmpleado(EmpleadoDTO dto);

    @Named("generateFechaIngresoLaboralDate")
    static LocalDate generateFechaIngresoLaboralDate(LocalDateTime fechaIngresoLaboral) {
        return fechaIngresoLaboral.toLocalDate();
    }
}

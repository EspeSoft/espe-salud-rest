package com.espe.salud.mapper.paciente;

import com.espe.salud.domain.entities.paciente.Empleado;
import com.espe.salud.domain.entities.paciente.Estudiante;
import com.espe.salud.dto.paciente.EmpleadoDTO;
import com.espe.salud.dto.paciente.EstudianteDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EmpleadoDTO toEmpleadoDTO(Empleado empleado);

    List<EmpleadoDTO> toEmpleadosDTO(List<Empleado> empleados);

    @InheritInverseConfiguration
    Empleado toEmpleado(EmpleadoDTO dto);
}

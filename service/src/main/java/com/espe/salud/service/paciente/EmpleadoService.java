package com.espe.salud.service.paciente;


import com.espe.salud.domain.entities.paciente.Empleado;
import com.espe.salud.dto.paciente.EmpleadoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmpleadoService {
    EmpleadoDTO save(EmpleadoDTO empleado);

    Optional<Empleado> findExisting(EmpleadoDTO empleadoDTO);

    Optional<EmpleadoDTO> findById(Long codigo);

    EmpleadoDTO toDTO(Empleado empleado);

    Empleado toEntity(EmpleadoDTO dto);
}

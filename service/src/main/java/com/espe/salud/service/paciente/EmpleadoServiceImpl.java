package com.espe.salud.service.paciente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.paciente.Empleado;
import com.espe.salud.dto.paciente.EmpleadoDTO;
import com.espe.salud.mapper.paciente.EmpleadoMapper;
import com.espe.salud.persistence.paciente.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper mapper;

    @Autowired
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, EmpleadoMapper mapper) {
        this.empleadoRepository = empleadoRepository;
        this.mapper = mapper;
    }

    @Override
    public EmpleadoDTO save(EmpleadoDTO empleado) {
        Optional<Empleado> optional = findExisting(empleado);
        if (!optional.isPresent()) {
            Empleado domainObject = toEntity(empleado);
            return toDTO(empleadoRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un empleado registrada para ese código[%s]", empleado.getId()));
        }
    }

    @Override
    public Optional<Empleado> findExisting(EmpleadoDTO empleadoDTO) {
        return empleadoRepository.findByCodigo(empleadoDTO.getId());
    }

    @Override
    public Optional<EmpleadoDTO> findById(Long codigo) {
        return Optional.empty();
    }

    @Override
    public EmpleadoDTO toDTO(Empleado empleado) {
        return mapper.toEmpleadoDTO(empleado);
    }

    @Override
    public Empleado toEntity(EmpleadoDTO dto) {
        return mapper.toEmpleado(dto);
    }
}

package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Procedimiento;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import com.espe.salud.mapper.evolucion.ProcedimientoMapper;
import com.espe.salud.mapper.evolucion.ProcedimientoMapperImpl;
import com.espe.salud.persistence.evolucion.ProcedimientoRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcedimientoServicelmpl implements ProcedimientoService{

    private final ProcedimientoRepository procedimientoRepository;
    private final ProcedimientoMapper mapper;


    public ProcedimientoServicelmpl(ProcedimientoRepository procedimientoRepository, ProcedimientoMapper mapper) {
        this.procedimientoRepository = procedimientoRepository;
        this.mapper = mapper;
    }

    @Override
    public ProcedimientoDTO save(ProcedimientoDTO procedimiento) {
        Optional<Procedimiento> optional = findExisting(procedimiento);
        if (!optional.isPresent()) {
            Procedimiento domainObject = toEntity(procedimiento);
            return toDTO(procedimientoRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", procedimiento.getId()));
        }
    }

    @Override
    public Optional<Procedimiento> findExisting(ProcedimientoDTO procedimientoDTO) {
        return procedimientoRepository.findByCodigo(procedimientoDTO.getId());
    }

    @Override
    public Optional<ProcedimientoDTO> findById(Long codigo) {
        return Optional.empty();
    }

    @Override
    public ProcedimientoDTO toDTO(Procedimiento procedimiento) {
        return mapper.toProcedimientoDTO(procedimiento);
    }

    @Override
    public Procedimiento toEntity(ProcedimientoDTO dto) {
        return mapper.toProcedimiento(dto);
    }


}

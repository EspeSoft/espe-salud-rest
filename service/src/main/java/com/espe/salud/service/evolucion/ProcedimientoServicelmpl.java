package com.espe.salud.service.evolucion;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Procedimiento;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import com.espe.salud.dto.paciente.PacienteDTO;
import com.espe.salud.mapper.evolucion.ProcedimientoMapper;
import com.espe.salud.mapper.evolucion.ProcedimientoMapperImpl;
import com.espe.salud.persistence.evolucion.ProcedimientoRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public ProcedimientoDTO save(ProcedimientoDTO procedimientoDTO) {
        Optional<Procedimiento> optional = procedimientoRepository.findById(procedimientoDTO.getId());
        //Optional<Procedimiento> optional = findExisting(procedimiento);
        if (!optional.isEmpty()) {
            Procedimiento domainObject = toEntity(procedimientoDTO);
            return toDTO(procedimientoRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", procedimientoDTO.getId()));
        }
    }

    @Override
    public ProcedimientoDTO update(ProcedimientoDTO procedimientoDTO) {
        Procedimiento domainObject = toEntity(procedimientoDTO);
        return toDTO(procedimientoRepository.save(domainObject));
    }


    @Override
    public Optional<Procedimiento> findExisting(ProcedimientoDTO procedimientoDTO) {
        return procedimientoRepository.findByCodigo(procedimientoDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return procedimientoRepository.findById(id).map(object -> {
            procedimientoRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<ProcedimientoDTO> findById(Long codigo) {
        return procedimientoRepository.findByCodigo(codigo).map(procedimiento -> mapper.toProcedimientoDTO(procedimiento));
}

    @Override
    public ProcedimientoDTO toDTO(Procedimiento procedimiento) {
        return mapper.toProcedimientoDTO(procedimiento);
    }

    @Override
    public Procedimiento toEntity(ProcedimientoDTO dto) {
        return mapper.toProcedimiento(dto);
    }

    @Override
    public List<ProcedimientoDTO> findAll() {
        List<Procedimiento> procedimientos = new ArrayList<>();
        procedimientoRepository.findAll().forEach(procedimientos::add);
        return mapper.toProcedimientosDTO(procedimientos);
    }


}

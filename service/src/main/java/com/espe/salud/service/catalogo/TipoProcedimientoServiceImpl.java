package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoProcedimiento;
import com.espe.salud.dto.catalogo.TipoProcedimientoDTO;
import com.espe.salud.mapper.catalogo.TipoProcedimientoMapper;
import com.espe.salud.persistence.catalogo.TipoProcedimientoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("TipoProcedimientoServiceImpl")
public class TipoProcedimientoServiceImpl extends GenericCRUDServiceImpl<TipoProcedimiento, TipoProcedimientoDTO> {
    private final TipoProcedimientoRepository tipoProcedimientoRepository;
    private final TipoProcedimientoMapper mapper;

    public TipoProcedimientoServiceImpl(TipoProcedimientoRepository tipoProcedimientoRepository, TipoProcedimientoMapper mapper) {
        this.tipoProcedimientoRepository = tipoProcedimientoRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoProcedimiento mapTo(TipoProcedimientoDTO domainObject) {
        return mapper.toTipoProcedimiento(domainObject);
    }

    @Override
    public TipoProcedimientoDTO build(TipoProcedimiento domainObject) {
        return mapper.toTipoProcedimientoDTO(domainObject);
    }

    @Override
    public Optional<TipoProcedimiento> findExisting(TipoProcedimientoDTO domainObject) {
        return tipoProcedimientoRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoProcedimientoDTO> findAllOrderByNameASC() {
        return null;
    }
}

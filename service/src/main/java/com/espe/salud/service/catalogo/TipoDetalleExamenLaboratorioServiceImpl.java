package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoDetalleExamenLaboratorioDTO;
import com.espe.salud.mapper.catalogo.TipoDetalleExamenLaboratorioMapper;
import com.espe.salud.persistence.catalogo.TipoDetalleExamenLaboratorioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("detalleExamenLaboratorioServiceImpl")
public class TipoDetalleExamenLaboratorioServiceImpl extends GenericCRUDServiceImpl<TipoDetalleExamenLaboratorio, TipoDetalleExamenLaboratorioDTO> {

    private final TipoDetalleExamenLaboratorioRepository domainRepository;

    private final TipoDetalleExamenLaboratorioMapper mapper;

    @Autowired
    public TipoDetalleExamenLaboratorioServiceImpl(TipoDetalleExamenLaboratorioRepository domainRepository,
                                                   TipoDetalleExamenLaboratorioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoDetalleExamenLaboratorio mapTo(TipoDetalleExamenLaboratorioDTO dtoObject) {
        return mapper.toDetalleExamenLaboratorio(dtoObject);
    }

    @Override
    public TipoDetalleExamenLaboratorioDTO build(TipoDetalleExamenLaboratorio domainObject) {
        return mapper.toDetalleExamenLaboratorioDTO(domainObject);
    }

    @Override
    public Optional<TipoDetalleExamenLaboratorio> findExisting(TipoDetalleExamenLaboratorioDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoDetalleExamenLaboratorioDTO> findAllOrderByNameASC() {

        return mapper.toDetalleExamenLaboratorioDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.DetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.DetalleExamenLaboratorioDTO;
import com.espe.salud.mapper.catalogo.DetalleExamenLaboratorioMapper;
import com.espe.salud.persistence.catalogo.DetalleExamenLaboratorioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("detalleExamenLaboratorioServiceImpl")
public class DetalleExamenLaboratorioServiceImpl extends GenericCRUDServiceImpl<DetalleExamenLaboratorio, DetalleExamenLaboratorioDTO> {

    private final DetalleExamenLaboratorioRepository domainRepository;

    private final DetalleExamenLaboratorioMapper mapper;

    @Autowired
    public DetalleExamenLaboratorioServiceImpl(DetalleExamenLaboratorioRepository domainRepository,
                                               DetalleExamenLaboratorioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public DetalleExamenLaboratorio mapTo(DetalleExamenLaboratorioDTO dtoObject){
        return mapper.toDetalleExamenLaboratorio(dtoObject);
    }

    @Override
    public DetalleExamenLaboratorioDTO build(DetalleExamenLaboratorio domainObject){
        return mapper.toDetalleExamenLaboratorioDTO(domainObject);
    }

    @Override
    public Optional<DetalleExamenLaboratorio> findExisting(DetalleExamenLaboratorioDTO domainObject){
        return domainRepository.findByCodigo(domainObject.getId());
    }
}

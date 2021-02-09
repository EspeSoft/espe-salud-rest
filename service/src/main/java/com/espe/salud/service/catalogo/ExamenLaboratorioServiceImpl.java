package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.ExamenLaboratorio;
import com.espe.salud.dto.catalogo.ExamenLaboratorioDTO;
import com.espe.salud.mapper.catalogo.ExamenLaboratorioMapper;
import com.espe.salud.persistence.catalogo.ExamenLaboratorioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("examenLaboratorioServiceImpl")
public class ExamenLaboratorioServiceImpl extends GenericCRUDServiceImpl<ExamenLaboratorio, ExamenLaboratorioDTO> {

    private final ExamenLaboratorioRepository domainRepository;

    private final ExamenLaboratorioMapper mapper;

    @Autowired
    public ExamenLaboratorioServiceImpl(ExamenLaboratorioRepository domainRepository,
                                        ExamenLaboratorioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public ExamenLaboratorio mapTo(ExamenLaboratorioDTO dtoObject){
        return mapper.toExamenLaboratorio(dtoObject);
    }

    @Override
    public ExamenLaboratorioDTO build(ExamenLaboratorio domainObject){
        return mapper.toExamenLaboratorioDTO(domainObject);
    }

    @Override
    public Optional<ExamenLaboratorio> findExisting(ExamenLaboratorioDTO domainObject){
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<ExamenLaboratorioDTO> findAllOrderByNameASC() {
        return null;
    }
}

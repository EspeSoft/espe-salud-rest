package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoExamenLaboratorioDTO;
import com.espe.salud.mapper.catalogo.TipoExamenLaboratorioMapper;
import com.espe.salud.persistence.catalogo.TipoExamenLaboratorioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("examenLaboratorioServiceImpl")
public class TipoExamenLaboratorioServiceImpl extends GenericCRUDServiceImpl<TipoExamenLaboratorio, TipoExamenLaboratorioDTO> {

    private final TipoExamenLaboratorioRepository domainRepository;

    private final TipoExamenLaboratorioMapper mapper;

    @Autowired
    public TipoExamenLaboratorioServiceImpl(TipoExamenLaboratorioRepository domainRepository,
                                            TipoExamenLaboratorioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoExamenLaboratorio mapTo(TipoExamenLaboratorioDTO dtoObject){
        return mapper.toExamenLaboratorio(dtoObject);
    }

    @Override
    public TipoExamenLaboratorioDTO build(TipoExamenLaboratorio domainObject){
        return mapper.toExamenLaboratorioDTO(domainObject);
    }

    @Override
    public Optional<TipoExamenLaboratorio> findExisting(TipoExamenLaboratorioDTO domainObject){
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoExamenLaboratorioDTO> findAllOrderByNameASC() {

        return mapper.toExamenLaboratorioDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

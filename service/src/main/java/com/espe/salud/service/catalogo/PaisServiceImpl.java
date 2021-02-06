package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Pais;
import com.espe.salud.dto.catalogo.PaisDTO;
import com.espe.salud.mapper.catalogo.PaisMapper;
import com.espe.salud.persistence.catalogo.PaisRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PaisServiceImpl")
public class PaisServiceImpl extends GenericCRUDServiceImpl<Pais, PaisDTO> {

    private final PaisRepository domainRepository;

    private final PaisMapper mapper;

    @Autowired
    public PaisServiceImpl(PaisRepository domainRepository,
                                             PaisMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Pais mapTo(PaisDTO dtoObject) {
        return mapper.toPais(dtoObject);
    }

    @Override
    public PaisDTO build(Pais domainObject) {
        return mapper.toPaisDTO(domainObject);
    }

    @Override
    public Optional<Pais> findExisting(PaisDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<PaisDTO> findAllOrderByNameASC() {
        return null;
    }
}

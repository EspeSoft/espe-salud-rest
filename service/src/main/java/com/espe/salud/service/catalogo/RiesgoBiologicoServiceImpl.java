package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoBiologico;
import com.espe.salud.dto.catalogo.RiesgoBiologicoDTO;
import com.espe.salud.mapper.catalogo.RiesgoBiologicoMapper;
import com.espe.salud.persistence.catalogo.RiesgoBiologicoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("riesgoBiologicoServiceImpl")
public class RiesgoBiologicoServiceImpl extends GenericCRUDServiceImpl<RiesgoBiologico, RiesgoBiologicoDTO> {

    private final RiesgoBiologicoRepository domainRepository;

    private final RiesgoBiologicoMapper mapper;

    @Autowired
    public RiesgoBiologicoServiceImpl(RiesgoBiologicoRepository domainRepository,
                                      RiesgoBiologicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoBiologico mapTo(RiesgoBiologicoDTO domainObject) {
        return mapper.toRiesgoBiologico(domainObject);
    }

    @Override
    public RiesgoBiologicoDTO build(RiesgoBiologico domainObject) {
        return mapper.toRiesgoBiologicoDTO(domainObject);
    }

    @Override
    public Optional<RiesgoBiologico> findExisting(RiesgoBiologicoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

}

package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoPsicosocial;
import com.espe.salud.dto.catalogo.RiesgoPsicosocialDTO;
import com.espe.salud.mapper.catalogo.RiesgoPsicosocialMapper;
import com.espe.salud.persistence.catalogo.RiesgoPsicosocialRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("riesgoPsicosocialServiceImpl")
public class RiesgoPsicosocialServiceImpl extends GenericCRUDServiceImpl<RiesgoPsicosocial, RiesgoPsicosocialDTO> {

    private final RiesgoPsicosocialRepository domainRepository;

    private final RiesgoPsicosocialMapper mapper;

    @Autowired
    public RiesgoPsicosocialServiceImpl(RiesgoPsicosocialRepository domainRepository,
                                        RiesgoPsicosocialMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoPsicosocial mapTo(RiesgoPsicosocialDTO domainObject) {
        return mapper.toRiesgoPsicosocial(domainObject);
    }

    @Override
    public RiesgoPsicosocialDTO build(RiesgoPsicosocial domainObject) {
        return mapper.toRiesgoPsicosocialDTO(domainObject);
    }

    @Override
    public Optional<RiesgoPsicosocial> findExisting(RiesgoPsicosocialDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

}

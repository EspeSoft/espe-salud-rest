package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoMecanico;
import com.espe.salud.dto.catalogo.RiesgoMecanicoDTO;
import com.espe.salud.mapper.catalogo.RiesgoMecanicoMapper;
import com.espe.salud.persistence.catalogo.RiesgoMecanicoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("riesgoMecanicoServiceImpl")
public class RiesgoMecanicoServiceImpl extends GenericCRUDServiceImpl<RiesgoMecanico, RiesgoMecanicoDTO> {

    private final RiesgoMecanicoRepository domainRepository;

    private final RiesgoMecanicoMapper mapper;

    @Autowired
    public RiesgoMecanicoServiceImpl(RiesgoMecanicoRepository domainRepository,
                                     RiesgoMecanicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoMecanico mapTo(RiesgoMecanicoDTO domainObject) {
        return mapper.toRiesgoMecanico(domainObject);
    }

    @Override
    public RiesgoMecanicoDTO build(RiesgoMecanico domainObject) {
        return mapper.toRiesgoMecanicoDTO(domainObject);
    }

    @Override
    public Optional<RiesgoMecanico> findExisting(RiesgoMecanicoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

}

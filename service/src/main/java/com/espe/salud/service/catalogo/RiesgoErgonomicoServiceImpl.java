package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoErgonomico;
import com.espe.salud.dto.catalogo.RiesgoErgonomicoDTO;
import com.espe.salud.mapper.catalogo.RiesgoErgonomicoMapper;
import com.espe.salud.persistence.catalogo.RiesgoErgonomicoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("riesgoErgonomicoServiceImpl")
public class RiesgoErgonomicoServiceImpl extends GenericCRUDServiceImpl<RiesgoErgonomico, RiesgoErgonomicoDTO> {

    private final RiesgoErgonomicoRepository domainRepository;

    private final RiesgoErgonomicoMapper mapper;

    @Autowired
    public RiesgoErgonomicoServiceImpl(RiesgoErgonomicoRepository domainRepository,
                                       RiesgoErgonomicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoErgonomico mapTo(RiesgoErgonomicoDTO domainObject) {
        return mapper.toRiesgoErgonomico(domainObject);
    }

    @Override
    public RiesgoErgonomicoDTO build(RiesgoErgonomico domainObject) {
        return mapper.toRiesgoErgonomicoDTO(domainObject);
    }

    @Override
    public Optional<RiesgoErgonomico> findExisting(RiesgoErgonomicoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

}

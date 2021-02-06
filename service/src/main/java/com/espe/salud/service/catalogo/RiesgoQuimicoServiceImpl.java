package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoQuimico;
import com.espe.salud.domain.entities.catalogo.RiesgoQuimico;
import com.espe.salud.dto.catalogo.RiesgoQuimicoDTO;
import com.espe.salud.dto.catalogo.RiesgoQuimicoDTO;
import com.espe.salud.mapper.catalogo.RiesgoQuimicoMapper;
import com.espe.salud.persistence.catalogo.RiesgoQuimicoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("riesgoQuimicoServiceImpl")
public class RiesgoQuimicoServiceImpl extends GenericCRUDServiceImpl<RiesgoQuimico, RiesgoQuimicoDTO> {

    private final RiesgoQuimicoRepository domainRepository;

    private final RiesgoQuimicoMapper mapper;

    @Autowired
    public RiesgoQuimicoServiceImpl(RiesgoQuimicoRepository domainRepository,
                                 RiesgoQuimicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoQuimico mapTo(RiesgoQuimicoDTO domainObject) {
        return mapper.toRiesgoQuimico(domainObject);
    }

    @Override
    public RiesgoQuimicoDTO build(RiesgoQuimico domainObject) {
        return mapper.toRiesgoQuimicoDTO(domainObject);
    }

    @Override
    public Optional<RiesgoQuimico> findExisting(RiesgoQuimicoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<RiesgoQuimicoDTO> findAllOrderByNameASC() {
        return mapper.toRiesgosQuimicosDTO(domainRepository.findAllByOrderByNombreAsc());
    }

}

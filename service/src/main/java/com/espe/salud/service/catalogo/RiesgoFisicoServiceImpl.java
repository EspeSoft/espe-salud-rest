package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoFisico;
import com.espe.salud.dto.catalogo.RiesgoFisicoDTO;
import com.espe.salud.mapper.catalogo.RiesgoFisicoMapper;
import com.espe.salud.persistence.catalogo.RiesgoFisicoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("riesgoFisicoServiceImpl")
public class RiesgoFisicoServiceImpl extends GenericCRUDServiceImpl<RiesgoFisico, RiesgoFisicoDTO> {

    private final RiesgoFisicoRepository domainRepository;

    private final RiesgoFisicoMapper mapper;

    @Autowired
    public RiesgoFisicoServiceImpl(RiesgoFisicoRepository domainRepository,
                                   RiesgoFisicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public RiesgoFisico mapTo(RiesgoFisicoDTO domainObject) {
        return mapper.toRiesgoFisico(domainObject);
    }

    @Override
    public RiesgoFisicoDTO build(RiesgoFisico domainObject) {
        return mapper.toRiesgoFisicoDTO(domainObject);
    }

    @Override
    public Optional<RiesgoFisico> findExisting(RiesgoFisicoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<RiesgoFisicoDTO> findAllOrderByNameASC() {
        return mapper.toRiesgosFisicosDTO(domainRepository.findAllByOrderByNombreAsc());
    }

}

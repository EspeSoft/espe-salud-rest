package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.ConsumoNocivo;
import com.espe.salud.dto.catalogo.ConsumoNocivoDTO;
import com.espe.salud.mapper.catalogo.ConsumoNocivoMapper;
import com.espe.salud.persistence.catalogo.ConsumoNocivoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ConsumoNocivoServiceImpl")
public class ConsumoNocivoServiceImpl extends GenericCRUDServiceImpl<ConsumoNocivo, ConsumoNocivoDTO> {

    private final ConsumoNocivoRepository domainRepository;

    private final ConsumoNocivoMapper mapper;

    @Autowired
    public ConsumoNocivoServiceImpl(ConsumoNocivoRepository domainRepository,
                                             ConsumoNocivoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public ConsumoNocivo mapTo(ConsumoNocivoDTO dtoObject) {
        return mapper.toConsumoNocivo(dtoObject);
    }

    @Override
    public ConsumoNocivoDTO build(ConsumoNocivo domainObject) {
        return mapper.toConsumoNocivoDTO(domainObject);
    }

    @Override
    public Optional<ConsumoNocivo> findExisting(ConsumoNocivoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<ConsumoNocivoDTO> findAllOrderByNameASC() {
        return null;
    }
}

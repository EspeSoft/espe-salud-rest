package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIE10;
import com.espe.salud.dto.catalogo.CodigoCIE10DTO;
import com.espe.salud.mapper.catalogo.CodigoCIE10Mapper;
import com.espe.salud.persistence.catalogo.CodigoCIE10Repository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("CodigoCIE10ServiceImpl")
public class CodigoCIE10ServiceImpl extends GenericCRUDServiceImpl<CodigoCIE10, CodigoCIE10DTO> {

    private final CodigoCIE10Repository codigoCIE10Repository;
    private final CodigoCIE10Mapper mapper;

    public CodigoCIE10ServiceImpl(CodigoCIE10Repository codigoCIE10Repository, CodigoCIE10Mapper mapper) {
        this.codigoCIE10Repository = codigoCIE10Repository;
        this.mapper = mapper;
    }

    @Override
    public CodigoCIE10 mapTo(CodigoCIE10DTO domainObject) {
        return mapper.toCodigoCIE10(domainObject);
    }

    @Override
    public CodigoCIE10DTO build(CodigoCIE10 domainObject) {
        return mapper.toCodigoCIE10DTO(domainObject);
    }

    @Override
    public Optional<CodigoCIE10> findExisting(CodigoCIE10DTO domainObject) {
        return codigoCIE10Repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<CodigoCIE10DTO> findAllOrderByNameASC() {
        return null;
    }
}

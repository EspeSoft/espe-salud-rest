package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.mapper.catalogo.EnfermedadCIE10Mapper;
import com.espe.salud.persistence.catalogo.EnfermedadCIE10Repository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("EnfermedadCIE10ServiceImpl")
public class EnfermedadCIE10ServiceImpl extends GenericCRUDServiceImpl<EnfermedadCIE10, EnfermedadCIE10DTO> {
    private final EnfermedadCIE10Repository enfermedadCIE10Repository;
    private final EnfermedadCIE10Mapper mapper;

    public EnfermedadCIE10ServiceImpl(EnfermedadCIE10Repository enfermedadCIE10Repository, EnfermedadCIE10Mapper mapper) {
        this.enfermedadCIE10Repository = enfermedadCIE10Repository;
        this.mapper = mapper;
    }

    @Override
    public EnfermedadCIE10 mapTo(EnfermedadCIE10DTO domainObject) {
        return mapper.toEnfermedadCIE10(domainObject);
    }

    @Override
    public EnfermedadCIE10DTO build(EnfermedadCIE10 domainObject) {

        return mapper.toEnfermedadCIE10DTO(domainObject);
    }

    @Override
    public Optional<EnfermedadCIE10> findExisting(EnfermedadCIE10DTO domainObject) {
        return enfermedadCIE10Repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<EnfermedadCIE10DTO> findAllOrderByNameASC() {
        return null;
    }
}

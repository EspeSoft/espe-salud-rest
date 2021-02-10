package com.espe.salud.service.catalogo;


import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import com.espe.salud.mapper.catalogo.EnfermedadCIE10Mapper;
import com.espe.salud.persistence.catalogo.EnfermedadCIE10Repository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadCIE10ServiceImpl implements EnfermedadCIE10Service {
    private final EnfermedadCIE10Repository enfermedadCIE10Repository;
    private final EnfermedadCIE10Mapper mapper;

    @Autowired
    public EnfermedadCIE10ServiceImpl(EnfermedadCIE10Repository enfermedadCIE10Repository, EnfermedadCIE10Mapper mapper) {
        this.enfermedadCIE10Repository = enfermedadCIE10Repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EnfermedadCIE10DTO> findById(String id) {
        return enfermedadCIE10Repository.findById(id).map(mapper::toEnfermedadCIE10DTO);
    }

    @Override
    @Transactional
    public EnfermedadCIE10DTO save(EnfermedadCIE10DTO enfermedadCIE10DTO) {
        Optional<EnfermedadCIE10> optional = enfermedadCIE10Repository.findByCodigo(enfermedadCIE10DTO.getCodigo());
        if (optional.isEmpty()) {
            EnfermedadCIE10 domainObject = mapper.toEnfermedadCIE10(enfermedadCIE10DTO);
            return mapper.toEnfermedadCIE10DTO(enfermedadCIE10Repository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una enfermedad CIE10 para ese código[%s]", enfermedadCIE10DTO.getCodigo()));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnfermedadCIE10DTO> findByCodigoOrNombre(String query) {
        query = StringUtils.capitalize(query);
        return mapper.toEnfermedadesCIE10DTO(enfermedadCIE10Repository.findByCodigoStartingWithOrNombreStartingWith(query, query));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnfermedadCIE10DTO> findAll() {
        return mapper.toEnfermedadesCIE10DTO(enfermedadCIE10Repository.findAllByOrderByNombreAsc());
    }
}

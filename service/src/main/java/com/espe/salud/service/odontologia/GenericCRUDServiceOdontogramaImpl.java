package com.espe.salud.service.odontologia;

import com.espe.salud.common.exception.EspeSaludException;
import com.espe.salud.dto.odontologia.DetalleOdontogramaSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public abstract class GenericCRUDServiceOdontogramaImpl<DOMAIN, DTO> implements GenericCRUDServiceOdontograma<DOMAIN, DTO> {

    @Autowired
    private JpaRepository<DOMAIN, Long> repository;

    @Override
    public DTO saveOrUpdate(DTO dtoObject) {
        Optional<DOMAIN> optional = findExisting(dtoObject);
        if (optional.isEmpty()) {
            DOMAIN domainObject = mapTo(dtoObject);
            return build(repository.save(domainObject));
        } else {
            throw new EspeSaludException(String.format("El objeto %s ya existe en base de datos", dtoObject));
        }
    }

    @Override
    public List<DTO> findAll(DTO dtoObject) {
        DOMAIN domainObject = mapTo(dtoObject);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnorePaths("id");
        List<DOMAIN> lstObjs = repository.findAll(Example.of(domainObject, matcher));
        return lstObjs.stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public DTO findById(Long id) {
        return repository.findById(id)
                .map(this::build)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el recurso para el id: " + id));
    }

    @Override
    public boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }
}

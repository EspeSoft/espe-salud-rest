package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.OrientacionSexual;
import com.espe.salud.dto.catalogo.OrientacionSexualDTO;
import com.espe.salud.mapper.catalogo.OrientacionSexualMapper;
import com.espe.salud.persistence.catalogo.OrientacionSexualRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("orientacionSexualServiceImpl")
public class OrientacionSexualServiceImpl extends GenericCRUDServiceImpl<OrientacionSexual, OrientacionSexualDTO> {

    private final OrientacionSexualRepository repository;
    private final OrientacionSexualMapper mapper;

    @Autowired
    public OrientacionSexualServiceImpl(OrientacionSexualRepository repository, OrientacionSexualMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public OrientacionSexual mapTo(OrientacionSexualDTO dtoObject) {
        return mapper.toOrientacionSexual(dtoObject);
    }

    @Override
    public OrientacionSexualDTO build(OrientacionSexual domainObject) {
        return mapper.toOrientacionSexualDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrientacionSexual> findExisting(OrientacionSexualDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrientacionSexualDTO> findAllOrderByNameASC() {
        return mapper.toOrientacionesSexualesDTO(repository.findAllByOrderByNombreAsc());
    }
}

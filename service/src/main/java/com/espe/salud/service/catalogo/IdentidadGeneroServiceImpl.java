package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.IdentidadGenero;
import com.espe.salud.dto.catalogo.IdentidadGeneroDTO;
import com.espe.salud.mapper.catalogo.IdentidadGeneroMapper;
import com.espe.salud.persistence.catalogo.IdentidadGeneroRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("identidadGeneroServiceImpl")
public class IdentidadGeneroServiceImpl extends GenericCRUDServiceImpl<IdentidadGenero, IdentidadGeneroDTO> {

    private final IdentidadGeneroRepository repository;
    private final IdentidadGeneroMapper mapper;

    @Autowired
    public IdentidadGeneroServiceImpl(IdentidadGeneroRepository repository, IdentidadGeneroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public IdentidadGenero mapTo(IdentidadGeneroDTO dtoObject) {
        return mapper.toIdentidadGenero(dtoObject);
    }

    @Override
    public IdentidadGeneroDTO build(IdentidadGenero domainObject) {
        return mapper.toIndentidadGeneroDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<IdentidadGenero> findExisting(IdentidadGeneroDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<IdentidadGeneroDTO> findAllOrderByNameASC() {
        return mapper.toIdentidadesGeneroDTO(repository.findAllByOrderByNombreAsc());
    }
}

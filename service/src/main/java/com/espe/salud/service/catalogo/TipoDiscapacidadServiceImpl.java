package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDiscapacidad;
import com.espe.salud.dto.catalogo.TipoDiscapacidadDTO;
import com.espe.salud.mapper.catalogo.TipoDiscapacidadMapper;
import com.espe.salud.persistence.catalogo.TipoDiscapacidadRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("tipoDiscapacidadServiceImpl")
public class TipoDiscapacidadServiceImpl extends GenericCRUDServiceImpl<TipoDiscapacidad, TipoDiscapacidadDTO> {

    private final TipoDiscapacidadRepository repository;
    private final TipoDiscapacidadMapper mapper;

    @Autowired
    public TipoDiscapacidadServiceImpl(TipoDiscapacidadRepository repository, TipoDiscapacidadMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TipoDiscapacidad mapTo(TipoDiscapacidadDTO dtoObject) {
        return mapper.toTipoDiscapacidad(dtoObject);
    }

    @Override
    public TipoDiscapacidadDTO build(TipoDiscapacidad domainObject) {
        return mapper.toTipoDiscapacidadDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoDiscapacidad> findExisting(TipoDiscapacidadDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoDiscapacidadDTO> findAllOrderByNameASC() {
        return mapper.toTiposDiscapacidadDTO(repository.findAllByOrderByNombreAsc());
    }
}

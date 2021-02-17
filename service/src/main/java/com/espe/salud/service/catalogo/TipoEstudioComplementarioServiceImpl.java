package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEstudioComplementario;
import com.espe.salud.dto.catalogo.TipoEstudioComplementarioDTO;
import com.espe.salud.mapper.catalogo.TipoEstudioComplementarioMapper;
import com.espe.salud.persistence.catalogo.TipoEstudioComplementarioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("tipoEstudioComplementarioServiceImpl")
public class TipoEstudioComplementarioServiceImpl extends GenericCRUDServiceImpl<TipoEstudioComplementario, TipoEstudioComplementarioDTO> {

    private final TipoEstudioComplementarioRepository repository;
    private final TipoEstudioComplementarioMapper mapper;

    @Autowired
    public TipoEstudioComplementarioServiceImpl(TipoEstudioComplementarioRepository repository,
                                                TipoEstudioComplementarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TipoEstudioComplementario mapTo(TipoEstudioComplementarioDTO dtoObject) {
        return mapper.toTipoEstudioComplementario(dtoObject);
    }

    @Override
    public TipoEstudioComplementarioDTO build(TipoEstudioComplementario domainObject) {
        return mapper.toTipoEstudioComplementarioDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoEstudioComplementario> findExisting(TipoEstudioComplementarioDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoEstudioComplementarioDTO> findAllOrderByNameASC() {
        return mapper.toTiposEstudioComplementario(repository.findAllByOrderByNombreAsc());
    }
}

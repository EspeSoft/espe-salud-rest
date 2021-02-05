package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEgreso;
import com.espe.salud.dto.catalogo.TipoEgresoDTO;
import com.espe.salud.mapper.catalogo.TipoEgresoMapper;
import com.espe.salud.persistence.catalogo.TipoEgresoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("tipoEgresoServiceImpl")
public class TipoEgresoServiceImpl extends GenericCRUDServiceImpl<TipoEgreso, TipoEgresoDTO> {

    private final TipoEgresoRepository repository;
    private final TipoEgresoMapper mapper;

    @Autowired
    public TipoEgresoServiceImpl(TipoEgresoRepository repository,
                                 TipoEgresoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TipoEgreso mapTo(TipoEgresoDTO dtoObject) {
        return mapper.toTipoEngreso(dtoObject);
    }

    @Override
    public TipoEgresoDTO build(TipoEgreso domainObject) {
        return mapper.toTipoEgresoDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoEgreso> findExisting(TipoEgresoDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoEgresoDTO> findAllOrderByNameASC() {
        return mapper.toTiposEgresoDTO(repository.findAllByOrderByNombreAsc());
    }
}

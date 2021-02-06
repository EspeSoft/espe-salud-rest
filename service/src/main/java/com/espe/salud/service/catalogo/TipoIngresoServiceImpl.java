package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoIngreso;
import com.espe.salud.dto.catalogo.TipoIngresoDTO;
import com.espe.salud.mapper.catalogo.TipoIngresoMapper;
import com.espe.salud.persistence.catalogo.TipoIngresoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("tipoIngresoServiceImpl")
public class TipoIngresoServiceImpl extends GenericCRUDServiceImpl<TipoIngreso, TipoIngresoDTO> {

    private final TipoIngresoMapper mapper;
    private final TipoIngresoRepository repository;

    @Autowired
    public TipoIngresoServiceImpl(TipoIngresoMapper mapper,
                                  TipoIngresoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TipoIngreso mapTo(TipoIngresoDTO dtoObject) {
        return mapper.toTipoIngreso(dtoObject);
    }

    @Override
    public TipoIngresoDTO build(TipoIngreso domainObject) {
        return mapper.toTipoIngresoDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoIngreso> findExisting(TipoIngresoDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoIngresoDTO> findAllOrderByNameASC() {
        return mapper.toTiposIngresoDTO(repository.findAllByOrderByNombreAsc());
    }
}

package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Plurinacionalidad;
import com.espe.salud.dto.catalogo.PlurinacionalidadDTO;
import com.espe.salud.mapper.catalogo.PlurinacionalidadMapper;
import com.espe.salud.persistence.catalogo.PlurinacionalidadRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("plurinacionalidadServiceImpl")
public class PlurinacionalidadServiceImpl extends GenericCRUDServiceImpl<Plurinacionalidad, PlurinacionalidadDTO> {
    private final PlurinacionalidadRepository repository;
    private final PlurinacionalidadMapper mapper;

    @Autowired
    public PlurinacionalidadServiceImpl(PlurinacionalidadRepository repository, PlurinacionalidadMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Plurinacionalidad mapTo(PlurinacionalidadDTO dtoObject) {
        return mapper.toPlurinacionalidad(dtoObject);
    }

    @Override
    public PlurinacionalidadDTO build(Plurinacionalidad domainObject) {
        return mapper.toPlurinacionalidadDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Plurinacionalidad> findExisting(PlurinacionalidadDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlurinacionalidadDTO> findAllOrderByNameASC() {
        return mapper.toPlurinacionalidadesDTO(repository.findAllByOrderByNombreAsc());
    }
}

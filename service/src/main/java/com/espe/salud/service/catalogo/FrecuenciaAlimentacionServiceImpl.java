package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaAlimentacion;
import com.espe.salud.dto.catalogo.FrecuenciaAlimentacionDTO;
import com.espe.salud.mapper.catalogo.FrecuenciaAlimentacionMapper;
import com.espe.salud.persistence.catalogo.FrecuenciaAlimentacionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("frecuenciaAlimentacionServiceImpl")
public class FrecuenciaAlimentacionServiceImpl extends GenericCRUDServiceImpl<FrecuenciaAlimentacion, FrecuenciaAlimentacionDTO> {

    private final FrecuenciaAlimentacionRepository repository;
    private final FrecuenciaAlimentacionMapper mapper;

    @Autowired
    public FrecuenciaAlimentacionServiceImpl(FrecuenciaAlimentacionRepository repository, FrecuenciaAlimentacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FrecuenciaAlimentacion mapTo(FrecuenciaAlimentacionDTO dtoObject) {
        return mapper.toFrecuenciaAlimentacion(dtoObject);
    }

    @Override
    public FrecuenciaAlimentacionDTO build(FrecuenciaAlimentacion domainObject) {
        return mapper.toFrecuenciaAlimentacionDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FrecuenciaAlimentacion> findExisting(FrecuenciaAlimentacionDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FrecuenciaAlimentacionDTO> findAllOrderByNameASC() {
        return mapper.toFrecuenciasAlimentacion(repository.findAllByOrderByNombreAsc());
    }
}

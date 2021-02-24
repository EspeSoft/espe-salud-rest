package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.NivelInstruccion;
import com.espe.salud.dto.catalogo.NivelInstruccionDTO;
import com.espe.salud.mapper.catalogo.NivelInstruccionMapper;
import com.espe.salud.persistence.catalogo.NivelInstruccionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("nivelInstruccionServiceImpl")
public class NivelInstruccionServiceImpl extends GenericCRUDServiceImpl<NivelInstruccion, NivelInstruccionDTO> {
    private final NivelInstruccionRepository repository;
    private final NivelInstruccionMapper mapper;

    @Autowired
    public NivelInstruccionServiceImpl(
            NivelInstruccionRepository repository,
            NivelInstruccionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public NivelInstruccion mapTo(NivelInstruccionDTO dtoObject) {
        return mapper.toNivelInstruccion(dtoObject);
    }

    @Override
    public NivelInstruccionDTO build(NivelInstruccion domainObject) {
        return mapper.toNivelInstruccionDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NivelInstruccion> findExisting(NivelInstruccionDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NivelInstruccionDTO> findAllOrderByNameASC() {
        return mapper.toNivelesInstruccion(repository.findAllByOrderByNombreAsc());
    }
}

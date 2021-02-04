package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.MotivoAtencion;
import com.espe.salud.dto.catalogo.MotivoAtencionDTO;
import com.espe.salud.mapper.catalogo.MotivoAtencionMapper;
import com.espe.salud.persistence.catalogo.MotivoAtencionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("motivoAtencionServiceImpl")
public class MotivoAtencionServiceImpl extends GenericCRUDServiceImpl<MotivoAtencion, MotivoAtencionDTO> {
    private final MotivoAtencionRepository repository;
    private final MotivoAtencionMapper mapper;

    @Autowired
    public MotivoAtencionServiceImpl(MotivoAtencionRepository repository, MotivoAtencionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MotivoAtencion mapTo(MotivoAtencionDTO dtoObject) {
        return mapper.toMotivoAtencion(dtoObject);
    }

    @Override
    public MotivoAtencionDTO build(MotivoAtencion domainObject) {
        return mapper.toMotivoAtencionDTO(domainObject);
    }

    @Override
    public Optional<MotivoAtencion> findExisting(MotivoAtencionDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<MotivoAtencionDTO> findAllOrderByNameASC() {
        return mapper.toMotivosAtencionDTO(repository.findAllByOrderByNombreAsc());
    }
}

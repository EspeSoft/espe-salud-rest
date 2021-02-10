package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoEnfermedad;
import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;
import com.espe.salud.mapper.catalogo.GrupoEnfermedadMapper;
import com.espe.salud.persistence.catalogo.GrupoEnfermedadRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("GrupoEnfermedadServiceImpl")
public class GrupoEnfermedadServiceImpl extends GenericCRUDServiceImpl<GrupoEnfermedad, GrupoEnfermedadDTO> {
    private final GrupoEnfermedadRepository grupoEnfermedadRepository;
    private final GrupoEnfermedadMapper mapper;

    public GrupoEnfermedadServiceImpl(GrupoEnfermedadRepository grupoEnfermedadRepository, GrupoEnfermedadMapper mapper) {
        this.grupoEnfermedadRepository = grupoEnfermedadRepository;
        this.mapper = mapper;
    }

    @Override
    public GrupoEnfermedad mapTo(GrupoEnfermedadDTO domainObject) {
        return mapper.toGrupoEnfermedad(domainObject);
    }

    @Override
    public GrupoEnfermedadDTO build(GrupoEnfermedad domainObject) {
        return mapper.toGrupoEnfermedadDTO(domainObject);
    }

    @Override
    public Optional<GrupoEnfermedad> findExisting(GrupoEnfermedadDTO domainObject) {
        return grupoEnfermedadRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<GrupoEnfermedadDTO> findAllOrderByNameASC() {
        return null;
    }
}

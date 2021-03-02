package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedad;
import com.espe.salud.dto.catalogo.TipoEnfermedadDTO;
import com.espe.salud.mapper.catalogo.TipoEnfermedadMapper;
import com.espe.salud.persistence.catalogo.TipoEnfermedadRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("tipoEnfermedadServiceImpl")
public class TipoEnfermedadServiceImpl extends GenericCRUDServiceImpl<TipoEnfermedad, TipoEnfermedadDTO> {

    private final TipoEnfermedadRepository domainRepository;

    private final TipoEnfermedadMapper mapper;

    @Autowired
    public TipoEnfermedadServiceImpl(TipoEnfermedadRepository domainRepository,
                                     TipoEnfermedadMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoEnfermedad mapTo(TipoEnfermedadDTO dtoObject) {
        return mapper.toTipoEnfermedad(dtoObject);
    }

    @Override
    public TipoEnfermedadDTO build(TipoEnfermedad domainObject) {
        return mapper.toTipoEnfermedadDTO(domainObject);
    }

    @Override
    public Optional<TipoEnfermedad> findExisting(TipoEnfermedadDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoEnfermedadDTO> findAllOrderByNameASC() {
        return null;
    }
}

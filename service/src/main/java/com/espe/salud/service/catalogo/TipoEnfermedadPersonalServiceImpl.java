package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoEnfermedadPersonal;
import com.espe.salud.dto.catalogo.TipoEnfermedadPersonalDTO;
import com.espe.salud.mapper.catalogo.TipoEnfermedadPersonalMapper;
import com.espe.salud.persistence.catalogo.TipoEnfermedadPersonalRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("tipoEnfermedadPersonalServiceImpl")
public class TipoEnfermedadPersonalServiceImpl extends GenericCRUDServiceImpl<TipoEnfermedadPersonal, TipoEnfermedadPersonalDTO> {

    private final TipoEnfermedadPersonalRepository domainRepository;

    private final TipoEnfermedadPersonalMapper mapper;

    @Autowired
    public TipoEnfermedadPersonalServiceImpl(TipoEnfermedadPersonalRepository domainRepository,
                                             TipoEnfermedadPersonalMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public TipoEnfermedadPersonal mapTo(TipoEnfermedadPersonalDTO dtoObject) {
        return mapper.toTipoEnfermedadPersonal(dtoObject);
    }

    @Override
    public TipoEnfermedadPersonalDTO build(TipoEnfermedadPersonal domainObject) {
        return mapper.toTipoEnfermedadPersonalDTO(domainObject);
    }

    @Override
    public Optional<TipoEnfermedadPersonal> findExisting(TipoEnfermedadPersonalDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<TipoEnfermedadPersonalDTO> findAllOrderByNameASC() {
        return null;
    }
}

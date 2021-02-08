package com.espe.salud.service.catalogo;


import com.espe.salud.domain.entities.catalogo.Asociacion;
import com.espe.salud.dto.catalogo.AsociacionDTO;
import com.espe.salud.mapper.catalogo.AsociacionMapper;
import com.espe.salud.persistence.catalogo.AsociacionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("asociacionServiceImpl")
public class AsociacionServiceImpl  extends GenericCRUDServiceImpl<Asociacion, AsociacionDTO> {

    private final AsociacionRepository domainRepository;

    private final AsociacionMapper mapper;

    @Autowired
    public AsociacionServiceImpl(AsociacionRepository domainRepository, AsociacionMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }


    @Override
    public Asociacion mapTo(AsociacionDTO dtoObject) {
        return mapper.toAsociacionDTO(dtoObject);
    }

    @Override
    public AsociacionDTO build(Asociacion domainObject) {
        return mapper.toAsociacionDTO(domainObject);
    }

    @Override
    public Optional<Asociacion> findExisting(AsociacionDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<AsociacionDTO> findAllOrderByNameASC() {
        return mapper.toAsociacionesDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

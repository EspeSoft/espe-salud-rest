package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.EstudioComplementario;
import com.espe.salud.dto.catalogo.EstudioComplementarioDTO;
import com.espe.salud.mapper.catalogo.EstudioComplementarioMapper;
import com.espe.salud.persistence.catalogo.EstudioComplementarioRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("estudioComplementarioServiceImpl")
public class EstudioComplementarioServiceImpl extends GenericCRUDServiceImpl<EstudioComplementario, EstudioComplementarioDTO> {

    private final EstudioComplementarioRepository domainRepository;

    private final EstudioComplementarioMapper mapper;

    @Autowired
    public EstudioComplementarioServiceImpl(EstudioComplementarioRepository domainRepository,
                                            EstudioComplementarioMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public EstudioComplementario mapTo(EstudioComplementarioDTO dtoObject){
        return mapper.toEstudioComplementario(dtoObject);
    }

    @Override
    public EstudioComplementarioDTO build(EstudioComplementario domainObject){
        return mapper.toEstudioComplementarioDTO(domainObject);
    }

    @Override
    public Optional<EstudioComplementario> findExisting(EstudioComplementarioDTO domainObject){
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<EstudioComplementarioDTO> findAllOrderByNameASC() {
        return null;
    }
}

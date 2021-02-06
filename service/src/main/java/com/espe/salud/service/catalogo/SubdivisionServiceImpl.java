package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import com.espe.salud.dto.catalogo.SubdivisionDTO;
import com.espe.salud.mapper.catalogo.SubdivisionMapper;
import com.espe.salud.persistence.catalogo.SubdivisionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SubdivisionServiceImpl")
public class SubdivisionServiceImpl extends GenericCRUDServiceImpl<Subdivision, SubdivisionDTO> {

    private final SubdivisionRepository domainRepository;

    private final SubdivisionMapper mapper;

    @Autowired
    public SubdivisionServiceImpl(SubdivisionRepository domainRepository,
                                             SubdivisionMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Subdivision mapTo(SubdivisionDTO dtoObject) {
        return mapper.toSubdivision(dtoObject);
    }

    @Override
    public SubdivisionDTO build(Subdivision domainObject) {
        return mapper.toSubdivisionDTO(domainObject);
    }

    @Override
    public Optional<Subdivision> findExisting(SubdivisionDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<SubdivisionDTO> findAllOrderByNameASC() {
        return null;
    }
}

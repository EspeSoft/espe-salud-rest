package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.ProblemaSocial;
import com.espe.salud.dto.catalogo.ProblemaSocialDTO;
import com.espe.salud.mapper.catalogo.ProblemaSocialMapper;
import com.espe.salud.persistence.catalogo.ProblemaSocialRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("problemaSocialServiceImpl")
public class ProblemaSocialServiceImpl extends GenericCRUDServiceImpl<ProblemaSocial, ProblemaSocialDTO> {
    private final ProblemaSocialRepository repository;
    private final ProblemaSocialMapper mapper;

    @Autowired
    public ProblemaSocialServiceImpl(ProblemaSocialRepository repository,
                                     ProblemaSocialMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProblemaSocial mapTo(ProblemaSocialDTO dtoObject) {
        return mapper.toProblemaSocial(dtoObject);
    }

    @Override
    public ProblemaSocialDTO build(ProblemaSocial domainObject) {
        return mapper.toProblemaSocialDTO(domainObject);
    }

    @Override
    public Optional<ProblemaSocial> findExisting(ProblemaSocialDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<ProblemaSocialDTO> findAllOrderByNameASC() {
        return mapper.toProblemasSocialesDTO(repository.findAllByOrderByNombreAsc());
    }
}

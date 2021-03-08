package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.RelacionEspe;
import com.espe.salud.dto.catalogo.RelacionEspeDTO;
import com.espe.salud.mapper.catalogo.RelacionEspeMapper;
import com.espe.salud.persistence.catalogo.RelacionEspeRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("relacionEspeServiceImpl")
public class RelacionEspeServiceImpl extends GenericCRUDServiceImpl<RelacionEspe, RelacionEspeDTO> {

    private final RelacionEspeRepository repository;
    private final RelacionEspeMapper mapper;

    @Autowired
    public RelacionEspeServiceImpl(RelacionEspeRepository repository, RelacionEspeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RelacionEspe mapTo(RelacionEspeDTO dtoObject) {
        return mapper.toRelacionEspe(dtoObject);
    }

    @Override
    public RelacionEspeDTO build(RelacionEspe domainObject) {
        return mapper.toRelacionEspeDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RelacionEspe> findExisting(RelacionEspeDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RelacionEspeDTO> findAllOrderByNameASC() {
        return mapper.toRelacionesEspe(repository.findAllByOrderByNombreAsc());
    }
}

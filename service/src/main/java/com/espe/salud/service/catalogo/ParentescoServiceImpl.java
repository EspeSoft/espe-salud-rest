package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Parentesco;
import com.espe.salud.dto.catalogo.ParentescoDTO;
import com.espe.salud.mapper.catalogo.ParentescoMapper;
import com.espe.salud.persistence.catalogo.ParentescoRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("parentescoServiceImpl")
public class ParentescoServiceImpl extends GenericCRUDServiceImpl<Parentesco, ParentescoDTO> {

    private final ParentescoRepository domainRepository;

    private final ParentescoMapper mapper;

    @Autowired
    public ParentescoServiceImpl(ParentescoRepository domainRepository,
                                 ParentescoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Parentesco mapTo(ParentescoDTO domainObject) {
        return mapper.toParentesco(domainObject);
    }

    @Override
    public ParentescoDTO build(Parentesco domainObject) {
        return mapper.toParentescoDTO(domainObject);
    }

    @Override
    public Optional<Parentesco> findExisting(ParentescoDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<ParentescoDTO> findAllOrderByNameASC() {
        return mapper.toParentescosDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

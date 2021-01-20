package com.salud.espe.service.catalogo;

import com.espe.salud.domain.Parentesco;
import com.espe.salud.dto.ParentescoDTO;
import com.espe.salud.mapper.ParentescoMapper;
import com.espe.salud.persitence.ParentescoRepository;
import com.salud.espe.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userServiceImpl")
public class ParentescoServiceImpl extends GenericCRUDServiceImpl<Parentesco, ParentescoDTO> {

    @Autowired
    private ParentescoRepository domainRepository;

    @Autowired
    private ParentescoMapper mapper;

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
        return domainRepository.findByCodigo(domainObject.getCodigo());
    }
}

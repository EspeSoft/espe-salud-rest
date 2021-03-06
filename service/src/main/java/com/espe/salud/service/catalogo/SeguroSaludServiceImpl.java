package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.SeguroSalud;
import com.espe.salud.dto.catalogo.SeguroSaludDTO;
import com.espe.salud.mapper.catalogo.SeguroSaludMapper;
import com.espe.salud.persistence.catalogo.SeguroSaludRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("seguroSaludServiceImpl")
public class SeguroSaludServiceImpl extends GenericCRUDServiceImpl<SeguroSalud, SeguroSaludDTO> {

    private final SeguroSaludRepository domainRepository;

    private final SeguroSaludMapper mapper;

    @Autowired
    public SeguroSaludServiceImpl(SeguroSaludRepository domainRepository, SeguroSaludMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }


    @Override
    public SeguroSalud mapTo(SeguroSaludDTO dtoObject) {
        return mapper.toSeguroSalud(dtoObject);
    }

    @Override
    public SeguroSaludDTO build(SeguroSalud domainObject) {
        return mapper.toSeguroSaludDTO(domainObject);
    }

    @Override
    public Optional<SeguroSalud> findExisting(SeguroSaludDTO domainObject) {
        return domainRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<SeguroSaludDTO> findAllOrderByNameASC() {
        return mapper.toSeguroSaludDTO(domainRepository.findAllByOrderByNombreAsc());
    }
}

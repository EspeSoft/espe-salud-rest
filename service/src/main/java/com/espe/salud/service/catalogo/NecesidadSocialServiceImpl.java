package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.NecesidadSocial;
import com.espe.salud.dto.catalogo.NecesidadSocialDTO;
import com.espe.salud.mapper.catalogo.NecesidadSocialMapper;
import com.espe.salud.persistence.catalogo.NecesidadSocialRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("necesidadSocialServiceImpl")
public class NecesidadSocialServiceImpl extends GenericCRUDServiceImpl<NecesidadSocial, NecesidadSocialDTO> {

    private final NecesidadSocialRepository repository;
    private final NecesidadSocialMapper mapper;

    @Autowired
    public NecesidadSocialServiceImpl(NecesidadSocialRepository repository,
                                      NecesidadSocialMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public NecesidadSocial mapTo(NecesidadSocialDTO dtoObject) {
        return mapper.toNecesidadSocial(dtoObject);
    }

    @Override
    public NecesidadSocialDTO build(NecesidadSocial domainObject) {
        return mapper.toNecesidadSocialDTO(domainObject);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NecesidadSocial> findExisting(NecesidadSocialDTO domainObject) {
        return repository.findByCodigo(domainObject.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NecesidadSocialDTO> findAllOrderByNameASC() {
        return mapper.toNecesidadesSocialesDTO(repository.findAllByOrderByNombreAsc());
    }
}

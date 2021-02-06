package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.OrganoSistema;
import com.espe.salud.dto.catalogo.OrganoSistemaDTO;
import com.espe.salud.mapper.catalogo.OrganoSistemaMapper;
import com.espe.salud.persistence.catalogo.OrganoSistemaRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("OrganoSistemaServiceImpl")
public class OrganoSistemaServiceImpl extends GenericCRUDServiceImpl<OrganoSistema, OrganoSistemaDTO> {
    private final OrganoSistemaRepository organoSistemaRepository;
    private final OrganoSistemaMapper mapper;

    public OrganoSistemaServiceImpl(OrganoSistemaRepository organoSistemaRepository, OrganoSistemaMapper mapper) {
        this.organoSistemaRepository = organoSistemaRepository;
        this.mapper = mapper;
    }

    @Override
    public OrganoSistema mapTo(OrganoSistemaDTO domainObject) {
        return mapper.toOrganoSistema(domainObject);
    }

    @Override
    public OrganoSistemaDTO build(OrganoSistema domainObject) {
        return mapper.toOrganoSistemaDTO(domainObject);
    }

    @Override
    public Optional<OrganoSistema> findExisting(OrganoSistemaDTO domainObject) {
        return organoSistemaRepository.findByCodigo(domainObject.getId());
    }
}

package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.dto.catalogo.AreaDTO;
import com.espe.salud.mapper.catalogo.AreaMapper;
import com.espe.salud.persistence.catalogo.AreaRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("AreaServiceImpl")
public class AreaServiceImpl extends GenericCRUDServiceImpl<Area, AreaDTO> {
    private final AreaRepository areaRepository;
    private final AreaMapper mapper;

    public AreaServiceImpl(AreaRepository areaRepository, AreaMapper mapper) {
        this.areaRepository = areaRepository;
        this.mapper = mapper;
    }

    @Override
    public Area mapTo(AreaDTO domainObject) {

        return mapper.toArea(domainObject);
    }

    @Override
    public AreaDTO build(Area domainObject) {

        return mapper.toAreaDTO(domainObject);
    }

    @Override
    public Optional<Area> findExisting(AreaDTO domainObject) {
        return areaRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<AreaDTO> findAllOrderByNameASC() {
        return null;
    }
}

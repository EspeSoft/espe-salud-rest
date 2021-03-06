package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.dto.catalogo.RegionDTO;
import com.espe.salud.mapper.catalogo.RegionMapper;
import com.espe.salud.persistence.catalogo.RegionRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("regionServiceImpl")
public class RegionServiceImpl extends GenericCRUDServiceImpl<Region, RegionDTO> {
    private final RegionRepository regionRepository;
    private final RegionMapper mapper;

    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, RegionMapper mapper) {
        this.regionRepository = regionRepository;
        this.mapper = mapper;
    }

    @Override
    public Region mapTo(RegionDTO domainObject) {
        return mapper.toRegion(domainObject);
    }

    @Override
    public RegionDTO build(Region domainObject) {
        return mapper.toRegionDTO(domainObject);
    }

    @Override
    public Optional<Region> findExisting(RegionDTO domainObject) {
        return regionRepository.findByCodigo(domainObject.getId());
    }

    @Override
    public List<RegionDTO> findAllOrderByNameASC() {
        return mapper.toRegionesDTO(regionRepository.findAllByOrderByNombreAsc());
    }
}




package com.espe.salud.service.catalogo;

import com.espe.salud.dto.catalogo.AreaDTO;
import com.espe.salud.mapper.catalogo.AreaMapper;
import com.espe.salud.persistence.catalogo.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;
    private final AreaMapper mapper;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository, AreaMapper mapper) {
        this.areaRepository = areaRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDTO> findAll() {
        return mapper.toAreasDTO(areaRepository.findAllByOrderByNombreAsc());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AreaDTO> findAllByRegion(Long idRegion) {
        return mapper.toAreasDTO(areaRepository.findByRegionCodigo(idRegion));
    }

    @Override
    @Transactional(readOnly = true)
    public AreaDTO findById(Long id) {
        return areaRepository.findById(id)
                .map(mapper::toAreaDTO)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el recurso para el id: " + id));    }
}

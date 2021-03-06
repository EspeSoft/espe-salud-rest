package com.espe.salud.service.examen;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.domain.entities.examen.ExamenExterno;
import com.espe.salud.dto.catalogo.RegionDTO;
import com.espe.salud.dto.examen.ExamenExternoDTO;
import com.espe.salud.mapper.examen.ExamenExternoMapper;
import com.espe.salud.persistence.examen.ExamenExternoRepository;
import com.espe.salud.service.GenericCRUDService;
import com.espe.salud.service.catalogo.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenExternoServiceImpl implements ExamenExternoService {
    private final ExamenExternoRepository repository;
    private final ExamenExternoMapper mapper;
    private final AreaService areaService;
    private final GenericCRUDService<Region, RegionDTO> regionService;

    @Autowired
    public ExamenExternoServiceImpl(
            ExamenExternoRepository repository,
            AreaService areaService,
            ExamenExternoMapper mapper,
            @Qualifier("regionServiceImpl") GenericCRUDService<Region, RegionDTO> regionService) {
        this.repository = repository;
        this.mapper = mapper;
        this.areaService = areaService;
        this.regionService = regionService;
    }

    @Override
    @Transactional
    public ExamenExternoDTO save(ExamenExternoDTO dto) {
        Optional<ExamenExterno> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            ExamenExterno domainObject = mapper.toExamenExterno(dto);
            ExamenExternoDTO examenExternoDTO = mapper.toExamenExternoDTO(repository.save(domainObject));
            examenExternoDTO.setArea(areaService.findById(examenExternoDTO.getIdArea()));
            examenExternoDTO.setRegion(regionService.findById(examenExternoDTO.getIdRegion()));
            return examenExternoDTO;
        } else {
            throw new ConflictException("Ya existe un examen registrado para ese id");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ExamenExternoDTO> findById(Long id) {
        return repository.findByCodigo(id).map(mapper::toExamenExternoDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamenExternoDTO> findByPaciente(Long idPaciente) {
        return mapper.toExamenesExternosDTO(repository.findByPacienteCodigo(idPaciente));
    }

    @Override
    @Transactional
    public ExamenExternoDTO update(ExamenExternoDTO dto) {
        ExamenExterno domainObject = mapper.toExamenExterno(dto);
        ExamenExternoDTO examenExternoDTO = mapper.toExamenExternoDTO(repository.save(domainObject));
        examenExternoDTO.setRegion(regionService.findById(examenExternoDTO.getIdRegion()));
        examenExternoDTO.setArea(areaService.findById(examenExternoDTO.getIdArea()));
        return examenExternoDTO;
    }

    @Override
    @Transactional
    public boolean delete(Long codigo) {
        return repository.findById(codigo).map(object -> {
            repository.deleteById(codigo);
            return true;
        }).orElse(false);
    }
}

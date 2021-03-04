package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import com.espe.salud.mapper.antecedente.PlanificacionFamiliarMapper;
import com.espe.salud.persistence.antecedente.PlanificacionFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanificacionFamiliarServiceImpl implements PlanificacionFamiliarService {

    private final PlanificacionFamiliarRepository domainRepository;
    private final PlanificacionFamiliarMapper mapper;

    @Autowired
    public PlanificacionFamiliarServiceImpl(PlanificacionFamiliarRepository domainRepository, PlanificacionFamiliarMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public PlanificacionFamiliarDTO save(PlanificacionFamiliarDTO planificacionFamiliarDTO) {
        Optional<PlanificacionFamiliar> optional = domainRepository.findById(planificacionFamiliarDTO.getId());
        if (!optional.isPresent()) {
            PlanificacionFamiliar domainObject = toEntity(planificacionFamiliarDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una planificacion familiar para el codigo [%s]", planificacionFamiliarDTO.getId()));
        }
    }

    @Override
    public PlanificacionFamiliarDTO update(PlanificacionFamiliarDTO planificacionFamiliarDTO) {
        PlanificacionFamiliar domainObject = toEntity(planificacionFamiliarDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<PlanificacionFamiliarDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(planificacionFamiliar -> toDTO(planificacionFamiliar));
    }

    @Override
    public List<PlanificacionFamiliarDTO> findAll() {
        return mapper.toPlanificacionFamiliarDTO(domainRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(planificacionFamiliar -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public PlanificacionFamiliarDTO toDTO(PlanificacionFamiliar planificacionFamiliar) {
        return mapper.toPlanificacionFamiliarDTO(planificacionFamiliar);
    }

    @Override
    public PlanificacionFamiliar toEntity(PlanificacionFamiliarDTO dto) {
        return mapper.toPlanificacionFamiliar(dto);
    }
}



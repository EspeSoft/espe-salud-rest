package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import com.espe.salud.mapper.antecedente.PlanificacionFamiliarMapper;
import com.espe.salud.persistence.antecedente.PlanificacionFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public PlanificacionFamiliarDTO save(PlanificacionFamiliarDTO dto) {
        Optional<PlanificacionFamiliar> optional = domainRepository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            PlanificacionFamiliar domainObject = mapper.toPlanificacionFamiliar(dto);
            return mapper.toPlanificacionFamiliarDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe una planificacion familiar para el codigo [%s]", dto.getId()));
        }
    }

    @Override
    @Transactional
    public PlanificacionFamiliarDTO update(PlanificacionFamiliarDTO dto) {
        PlanificacionFamiliar domainObject = mapper.toPlanificacionFamiliar(dto);
        return mapper.toPlanificacionFamiliarDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanificacionFamiliarDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(mapper::toPlanificacionFamiliarDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(planificacionFamiliar -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlanificacionFamiliarDTO> findByPaciente(Long idPaciente) {
        return mapper.toPlanificacionesFamiliaresDTO(domainRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}



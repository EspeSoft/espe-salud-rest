package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;
import com.espe.salud.mapper.ocupacional.FactorRiesgoPuestoActualMapper;
import com.espe.salud.persistence.ocupacional.FactorRiesgoPuestoActualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("factorRiesgoPuestoActualServiceImpl")
public class FactorRiesgoPuestoActualServiceImpl implements FactorRiesgoPuestoActualService {

    private final FactorRiesgoPuestoActualRepository repository;
    private final FactorRiesgoPuestoActualMapper mapper;

    @Autowired
    public FactorRiesgoPuestoActualServiceImpl(FactorRiesgoPuestoActualRepository repository, FactorRiesgoPuestoActualMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public FactorRiesgoPuestoActualDTO save(FactorRiesgoPuestoActualDTO factor) {
        Optional<FactorRiesgoPuestoActual> optional = repository.findByCodigo(factor.getId());
        if (!optional.isPresent()) {
            FactorRiesgoPuestoActual domainObject = toEntity(factor);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un factor de riesgo para el puesto actual registrado para ese código[%s]", factor.getId()));
        }
    }

    @Override
    public FactorRiesgoPuestoActualDTO update(FactorRiesgoPuestoActualDTO factor) {
        FactorRiesgoPuestoActual domainObject = toEntity(factor);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<FactorRiesgoPuestoActualDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(factor -> mapper.toFactorRiesgoPuestoActualDto(factor));
    }

    @Override
    public List<FactorRiesgoPuestoActualDTO> findByAntecedenteLaboral(Long idAntecedenteLaboral) {
        return mapper.toFactoreRiesgosPuestoActualDto(repository.findByAntecedenteLaboralCodigo(idAntecedenteLaboral));
    }

    @Override
    public FactorRiesgoPuestoActualDTO toDTO(FactorRiesgoPuestoActual factor) {
        return mapper.toFactorRiesgoPuestoActualDto(factor);
    }

    @Override
    public FactorRiesgoPuestoActual toEntity(FactorRiesgoPuestoActualDTO dto) {
        return mapper.toFactorRiesgoPuestoActual(dto);
    }
}

package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ActividadFisica;
import com.espe.salud.dto.antecedente.ActividadFisicaDTO;
import com.espe.salud.mapper.antecedente.ActividadFisicaMapper;
import com.espe.salud.persistence.antecedente.ActividadFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActividadFisicaServicelmpl implements ActividadFisicaService {
    private final ActividadFisicaRepository actividadFisicaRepository;
    private final ActividadFisicaMapper mapper;

    @Autowired
    public ActividadFisicaServicelmpl(ActividadFisicaRepository actividadFisicaRepository, ActividadFisicaMapper mapper) {
        this.actividadFisicaRepository = actividadFisicaRepository;
        this.mapper = mapper;
    }

    @Override
    public ActividadFisicaDTO save(ActividadFisicaDTO actividadFisica) {
        Optional< ActividadFisica > optional = findExisting(actividadFisica);
        if (!optional.isPresent()) {
            ActividadFisica domainObject = toEntity(actividadFisica);
            return toDTO(actividadFisicaRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", actividadFisica.getId()));
        }
    }

    @Override
    public ActividadFisicaDTO update(ActividadFisicaDTO actividadFisica) {
        ActividadFisica domainObject = toEntity(actividadFisica);
        return toDTO(actividadFisicaRepository.save(domainObject));
    }

    @Override
    public Optional<ActividadFisica> findExisting(ActividadFisicaDTO actividadFisicaDTO) {
        return actividadFisicaRepository.findByCodigo(actividadFisicaDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return  actividadFisicaRepository.findById(id).map(object -> {
            actividadFisicaRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<ActividadFisicaDTO> findByCodigo(Long codigo) {
        return actividadFisicaRepository.findByCodigo(codigo).map(actividadFisica -> mapper.toActividadFisicaDTO(actividadFisica));
    }

    @Override
    public ActividadFisicaDTO toDTO(ActividadFisica actividadFisica) {
        return mapper.toActividadFisicaDTO(actividadFisica);
    }

    @Override
    public ActividadFisica toEntity(ActividadFisicaDTO dto) {
        return mapper.toActividadFisica(dto);
    }

    @Override
    public List<ActividadFisicaDTO> findAll() {
        List<ActividadFisica> actividadFisicas = new ArrayList<>();
        actividadFisicaRepository.findAll().forEach(actividadFisicas::add);
        return mapper.toActicidadesFisicasDTO(actividadFisicas);
    }
}

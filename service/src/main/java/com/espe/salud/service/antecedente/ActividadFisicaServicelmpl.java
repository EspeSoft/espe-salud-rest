package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.ActividadFisica;
import com.espe.salud.dto.antecedente.ActividadFisicaDTO;
import com.espe.salud.mapper.antecedente.ActividadFisicaMapper;
import com.espe.salud.persistence.antecedente.ActividadFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadFisicaServicelmpl implements ActividadFisicaService {
    private final ActividadFisicaRepository repository;
    private final ActividadFisicaMapper mapper;

    @Autowired
    public ActividadFisicaServicelmpl(ActividadFisicaRepository actividadFisicaRepository, ActividadFisicaMapper mapper) {
        this.repository = actividadFisicaRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ActividadFisicaDTO save(ActividadFisicaDTO dto) {
        Optional<ActividadFisica> optional = repository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            ActividadFisica domainObject = mapper.toActividadFisica(dto);
            return mapper.toActividadFisicaDTO(repository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe una actividad física para ese ID");
        }
    }

    @Override
    @Transactional
    public ActividadFisicaDTO update(ActividadFisicaDTO dto) {
        ActividadFisica domainObject = mapper.toActividadFisica(dto);
        return mapper.toActividadFisicaDTO(repository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ActividadFisicaDTO> findById(Long codigo) {
        return repository.findByCodigo(codigo).map(mapper::toActividadFisicaDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActividadFisicaDTO> findByPaciente(Long idPaciente) {
        return mapper.toActividadesFisicasDTO(repository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.AntecedenteIncidenteTrabajo;
import com.espe.salud.domain.entities.ocupacional.AntecedenteIncidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteIncidenteTrabajoMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteIncidenteTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("antecedenteIncidenteTrabajoServiceImpl")
public class AntecedenteIncidenteTrabajoServiceImpl implements AntecedenteIncidenteTrabajoService {

    private final AntecedenteIncidenteTrabajoRepository repository;
    private final AntecedenteIncidenteTrabajoMapper mapper;

    @Autowired
    public AntecedenteIncidenteTrabajoServiceImpl(AntecedenteIncidenteTrabajoRepository repository, AntecedenteIncidenteTrabajoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteIncidenteTrabajoDTO save(AntecedenteIncidenteTrabajoDTO antecedente) {
        Optional<AntecedenteIncidenteTrabajo> optional = findExisting(antecedente);
        if (!optional.isPresent()) {
            AntecedenteIncidenteTrabajo domainObject = toEntity(antecedente);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", antecedente.getId()));
        }
    }

    @Override
    public AntecedenteIncidenteTrabajoDTO update(AntecedenteIncidenteTrabajoDTO antecedente) {
        AntecedenteIncidenteTrabajo domainObject = toEntity(antecedente);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteIncidenteTrabajo> findExisting(AntecedenteIncidenteTrabajoDTO antecedenteDTO) {
        return repository.findByCodigo(antecedenteDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return repository.findById(id).map(object -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<AntecedenteIncidenteTrabajoDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toAntecedenteIncidenteTrabajoDto(antecedente));
    }

    @Override
    public AntecedenteIncidenteTrabajoDTO toDTO(AntecedenteIncidenteTrabajo antecedente) {
        return mapper.toAntecedenteIncidenteTrabajoDto(antecedente);
    }

    @Override
    public AntecedenteIncidenteTrabajo toEntity(AntecedenteIncidenteTrabajoDTO dto) {
        return mapper.toAntecedenteIncidenteTrabajo(dto);
    }

    @Override
    public List<AntecedenteIncidenteTrabajoDTO> findAll() {
        List<AntecedenteIncidenteTrabajo> antecedentes = new ArrayList<>();
        repository.findAll().forEach(antecedentes::add);
        return mapper.toAntecedentesIncidentesTrabajoDto(antecedentes);
    }
}

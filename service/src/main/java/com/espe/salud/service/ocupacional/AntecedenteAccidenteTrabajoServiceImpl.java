package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteAccidenteTrabajoMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteAccidenteTrabajoRepository;
import com.espe.salud.service.GenericCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("antecedenteAccidenteTrabajoServiceImpl")
public class AntecedenteAccidenteTrabajoServiceImpl implements AntecedenteAccidenteTrabajoService {

    private final AntecedenteAccidenteTrabajoRepository repository;
    private final AntecedenteAccidenteTrabajoMapper mapper;

    @Autowired
    public AntecedenteAccidenteTrabajoServiceImpl(
            AntecedenteAccidenteTrabajoRepository repository,
            AntecedenteAccidenteTrabajoMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteAccidenteTrabajoDTO save(AntecedenteAccidenteTrabajoDTO antecedente) {
        Optional<AntecedenteAccidenteTrabajo> optional = findExisting(antecedente);
        if (!optional.isPresent()) {
            AntecedenteAccidenteTrabajo domainObject = toEntity(antecedente);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", antecedente.getId()));
        }
    }

    @Override
    public AntecedenteAccidenteTrabajoDTO update(AntecedenteAccidenteTrabajoDTO antecedente) {
        AntecedenteAccidenteTrabajo domainObject = toEntity(antecedente);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteAccidenteTrabajo> findExisting(AntecedenteAccidenteTrabajoDTO antecedenteDTO) {
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
    public Optional<AntecedenteAccidenteTrabajoDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toAntecedenteAccidenteTrabajoDto(antecedente));
    }

    @Override
    public AntecedenteAccidenteTrabajoDTO toDTO(AntecedenteAccidenteTrabajo antecedente) {
        return mapper.toAntecedenteAccidenteTrabajoDto(antecedente);
    }

    @Override
    public AntecedenteAccidenteTrabajo toEntity(AntecedenteAccidenteTrabajoDTO dto) {
        return mapper.toAntecedenteAccidenteTrabajo(dto);
    }

    @Override
    public List<AntecedenteAccidenteTrabajoDTO> findAll() {
        List<AntecedenteAccidenteTrabajo> antecedentes = new ArrayList<>();
        repository.findAll().forEach(antecedentes::add);
        return mapper.toAntecedentesAccidentesTrabajoDto(antecedentes);
    }
}
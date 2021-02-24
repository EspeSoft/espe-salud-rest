package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteEmpleoAnteriorMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteEmpleoAnteriorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("antecedenteEmpleoAnteriorServiceImpl")
public class AntecedenteEmpleoAnteriorServiceImpl implements AntecedenteEmpleoAnteriorService {

    private final AntecedenteEmpleoAnteriorRepository repository;
    private final AntecedenteEmpleoAnteriorMapper mapper;

    @Autowired
    public AntecedenteEmpleoAnteriorServiceImpl(AntecedenteEmpleoAnteriorRepository repository, AntecedenteEmpleoAnteriorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteEmpleoAnteriorDTO save(AntecedenteEmpleoAnteriorDTO antecedente) {
        Optional<AntecedenteEmpleoAnterior> optional = findExisting(antecedente);
        if (!optional.isPresent()) {
            AntecedenteEmpleoAnterior domainObject = toEntity(antecedente);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", antecedente.getId()));
        }
    }

    @Override
    public AntecedenteEmpleoAnteriorDTO update(AntecedenteEmpleoAnteriorDTO antecedente) {
        AntecedenteEmpleoAnterior domainObject = toEntity(antecedente);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteEmpleoAnterior> findExisting(AntecedenteEmpleoAnteriorDTO antecedenteDTO) {
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
    public Optional<AntecedenteEmpleoAnteriorDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toAntecedenteEmpleoAnteriorDto(antecedente));
    }

    @Override
    public AntecedenteEmpleoAnteriorDTO toDTO(AntecedenteEmpleoAnterior antecedente) {
        return mapper.toAntecedenteEmpleoAnteriorDto(antecedente);
    }

    @Override
    public AntecedenteEmpleoAnterior toEntity(AntecedenteEmpleoAnteriorDTO dto) {
        return mapper.toAntecedenteEmpleoAnterior(dto);
    }

    @Override
    public List<AntecedenteEmpleoAnteriorDTO> findAll() {
        List<AntecedenteEmpleoAnterior> antecedentes = new ArrayList<>();
        repository.findAll().forEach(antecedentes::add);
        return mapper.toAntecedentesEmpleosAnteriorDto(antecedentes);
    }
}

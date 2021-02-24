package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteEnfermedadProfesionalMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteEnfermedadProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("antecedenteEnfermedadProfesionalServiceImpl")
public class AntecedenteEnfermedadProfesionalServiceImpl implements AntecedenteEnfermedadProfesionalService {

    private final AntecedenteEnfermedadProfesionalRepository repository;
    private final AntecedenteEnfermedadProfesionalMapper mapper;

    @Autowired
    public AntecedenteEnfermedadProfesionalServiceImpl(AntecedenteEnfermedadProfesionalRepository repository, AntecedenteEnfermedadProfesionalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteEnfermedadProfesionalDTO save(AntecedenteEnfermedadProfesionalDTO antecedente) {
        Optional<AntecedenteEnfermedadProfesional> optional = findExisting(antecedente);
        if (!optional.isPresent()) {
            AntecedenteEnfermedadProfesional domainObject = toEntity(antecedente);
            return toDTO(repository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", antecedente.getId()));
        }
    }

    @Override
    public AntecedenteEnfermedadProfesionalDTO update(AntecedenteEnfermedadProfesionalDTO antecedente) {
        AntecedenteEnfermedadProfesional domainObject = toEntity(antecedente);
        return toDTO(repository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteEnfermedadProfesional> findExisting(AntecedenteEnfermedadProfesionalDTO antecedenteDTO) {
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
    public Optional<AntecedenteEnfermedadProfesionalDTO> findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo).map(antecedente -> mapper.toAntecedenteEnfermedadProfesionalDto(antecedente));
    }

    @Override
    public AntecedenteEnfermedadProfesionalDTO toDTO(AntecedenteEnfermedadProfesional antecedente) {
        return mapper.toAntecedenteEnfermedadProfesionalDto(antecedente);
    }

    @Override
    public AntecedenteEnfermedadProfesional toEntity(AntecedenteEnfermedadProfesionalDTO dto) {
        return mapper.toAntecedenteEnfermedadProfesional(dto);
    }

    @Override
    public List<AntecedenteEnfermedadProfesionalDTO> findAll() {
        List<AntecedenteEnfermedadProfesional> antecedentes = new ArrayList<>();
        repository.findAll().forEach(antecedentes::add);
        return mapper.toAntecedentesEnfermedadesProfesionalDto(antecedentes);
    }
}

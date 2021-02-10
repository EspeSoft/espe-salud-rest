package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePersonal;
import com.espe.salud.domain.entities.paciente.Paciente;
import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;
import com.espe.salud.mapper.antecedente.AntecedentePersonalMapper;
import com.espe.salud.persistence.antecedente.AntecedentePersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AntecedentePersonalServicelmpl implements AntecedentePersonalService{
    private final AntecedentePersonalRepository antecedentePersonalRepository;
    private final AntecedentePersonalMapper mapper;

    @Autowired
    public AntecedentePersonalServicelmpl(AntecedentePersonalRepository antecedentePersonalRepository, AntecedentePersonalMapper mapper) {
        this.antecedentePersonalRepository = antecedentePersonalRepository;
        this.mapper = mapper;
    }

    @Override
    public AntecedentePersonalDTO save(AntecedentePersonalDTO antecedentePersonal) {
        Optional<AntecedentePersonal> optional = findExisting(antecedentePersonal);
        if (!optional.isPresent()) {
            AntecedentePersonal domainObject = toEntity(antecedentePersonal);
            return toDTO(antecedentePersonalRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un paciente registrada para ese código[%s]", antecedentePersonal.getId()));
        }
    }

    @Override
    public AntecedentePersonalDTO update(AntecedentePersonalDTO antecedentePersonal) {
        AntecedentePersonal domainObject = toEntity(antecedentePersonal);
        return toDTO(antecedentePersonalRepository.save(domainObject));
    }

    @Override
    public Optional<AntecedentePersonal> findExisting(AntecedentePersonalDTO antecedentePersonalDTO) {
        return antecedentePersonalRepository.findByCodigo(antecedentePersonalDTO.getId());
    }

    @Override
    public Boolean delete(Long id) {
        return antecedentePersonalRepository.findById(id).map(object -> {
            antecedentePersonalRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public Optional<AntecedentePersonalDTO> findByCodigo(Long codigo) {
        return antecedentePersonalRepository.findByCodigo(codigo).map(antecedentePersonal -> mapper.toAntecedentePersonalDTO(antecedentePersonal));
    }

    @Override
    public AntecedentePersonalDTO toDTO(AntecedentePersonal antecedentePersonal) {
        return mapper.toAntecedentePersonalDTO(antecedentePersonal);
    }

    @Override
    public AntecedentePersonal toEntity(AntecedentePersonalDTO dto) {
        return mapper.toAntecedentePersonal(dto);
    }

    @Override
    public List<AntecedentePersonalDTO> findAll() {
        List<AntecedentePersonal> antecedentePersonals = new ArrayList<>();
        antecedentePersonalRepository.findAll().forEach(antecedentePersonals::add);
        return mapper.toAntecedentePersonalesDTO(antecedentePersonals);
    }
}

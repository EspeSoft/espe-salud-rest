package com.espe.salud.service.ocupacional;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import com.espe.salud.mapper.ocupacional.AntecedenteEmpleoAnteriorMapper;
import com.espe.salud.persistence.ocupacional.AntecedenteEmpleoAnteriorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AntecedenteEmpleoAnteriorServiceImpl implements AntecedenteEmpleoAnteriorService {

    private final AntecedenteEmpleoAnteriorRepository antecedenteEmpleoAnteriorRepository;
    private final AntecedenteEmpleoAnteriorMapper mapper;

    public AntecedenteEmpleoAnteriorServiceImpl(AntecedenteEmpleoAnteriorRepository antecedenteEmpleoAnteriorRepository, AntecedenteEmpleoAnteriorMapper mapper) {
        this.antecedenteEmpleoAnteriorRepository = antecedenteEmpleoAnteriorRepository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteEmpleoAnteriorDTO save(AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnterior) {
        Optional<AntecedenteEmpleoAnterior> optional = findExisting(antecedenteEmpleoAnterior);
        if (!optional.isPresent()) {
            AntecedenteEmpleoAnterior domainObject = toEntity(antecedenteEmpleoAnterior);
            return toDTO(antecedenteEmpleoAnteriorRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un procedimiento registrada para ese código[%s]", antecedenteEmpleoAnterior.getId()));
        }
    }

    @Override
    public Optional<AntecedenteEmpleoAnterior> findExisting(AntecedenteEmpleoAnteriorDTO antecedenteEmpleoAnteriorDTO) {
        return antecedenteEmpleoAnteriorRepository.findByCodigo(antecedenteEmpleoAnteriorDTO.getId());
    }

    @Override
    public Optional<AntecedenteEmpleoAnteriorDTO> findById(Long codigo) {
        return Optional.empty();
    }

    @Override
    public AntecedenteEmpleoAnteriorDTO toDTO(AntecedenteEmpleoAnterior antecedenteEmpleoAnterior) {
        return mapper.toAntecedenteEmpleoAnteriorDTO(antecedenteEmpleoAnterior);
    }

    @Override
    public AntecedenteEmpleoAnterior toEntity(AntecedenteEmpleoAnteriorDTO dto) {
        return mapper.toAntecedenteEmpleoAnterior(dto);
    }
}

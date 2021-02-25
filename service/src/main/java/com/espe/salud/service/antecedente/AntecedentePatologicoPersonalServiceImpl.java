package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoPersonal;
import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import com.espe.salud.mapper.antecedente.AntecedentePatologicoPersonalMapper;
import com.espe.salud.persistence.antecedente.AntecedentePatologicoPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedentePatologicoPersonalServiceImpl implements AntecedentePatologicoPersonalService{

    private final AntecedentePatologicoPersonalRepository personalRepository;
    private final AntecedentePatologicoPersonalMapper mapper;


    @Autowired
    public AntecedentePatologicoPersonalServiceImpl(AntecedentePatologicoPersonalRepository personalRepository, AntecedentePatologicoPersonalMapper mapper) {
        this.personalRepository = personalRepository;
        this.mapper = mapper;
    }

    @Override
    public AntecedentePatologicoPersonalDTO save(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO) {
        AntecedentePatologicoPersonal domainObject=toEntity(antecedentePatologicoPersonalDTO);
        return toDTO(personalRepository.save(domainObject));
    }

    @Override
    public AntecedentePatologicoPersonalDTO update(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO) {
        AntecedentePatologicoPersonal domainObject=toEntity(antecedentePatologicoPersonalDTO);
        return toDTO(personalRepository.save(domainObject));
    }

    @Override
    public Optional<AntecedentePatologicoPersonalDTO> findById(Long codigo) {
        return personalRepository.findByCodigo(codigo).map(this::toDTO);
    }

    @Override
    public List<AntecedentePatologicoPersonalDTO> findAll() {
        return mapper.toAntecedentePatologicoPersonalDTO(personalRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return personalRepository.findByCodigo(id).map(antecedentePatologicoPersonal -> {
            personalRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public AntecedentePatologicoPersonalDTO toDTO(AntecedentePatologicoPersonal antecedentePatologicoPersonal) {
        return mapper.toAntecedentePatologicoPersonalDTO(antecedentePatologicoPersonal);
    }

    @Override
    public AntecedentePatologicoPersonal toEntity(AntecedentePatologicoPersonalDTO dto) {
        return mapper.toAntecedentePatologicoPersonal(dto);
    }
}

package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoPersonal;
import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import com.espe.salud.mapper.antecedente.AntecedentePatologicoPersonalMapper;
import com.espe.salud.persistence.antecedente.AntecedentePatologicoPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public AntecedentePatologicoPersonalDTO save(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO) {
        Optional<AntecedentePatologicoPersonal> optional = personalRepository.findByCodigo(antecedentePatologicoPersonalDTO.getId());
        if (optional.isEmpty()) {
            AntecedentePatologicoPersonal domainObject=mapper.toAntecedentePatologicoPersonal(antecedentePatologicoPersonalDTO);
            return mapper.toAntecedentePatologicoPersonalDTO(personalRepository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe un antecedente patologico personal para ese ID");
        }

    }

    @Override
    @Transactional
    public AntecedentePatologicoPersonalDTO update(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO) {
        AntecedentePatologicoPersonal domainObject=mapper.toAntecedentePatologicoPersonal(antecedentePatologicoPersonalDTO);
        return mapper.toAntecedentePatologicoPersonalDTO(personalRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedentePatologicoPersonalDTO> findById(Long codigo) {
        return personalRepository.findByCodigo(codigo).map(mapper::toAntecedentePatologicoPersonalDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return personalRepository.findByCodigo(id).map(antecedentePatologicoPersonal -> {
            personalRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public List<AntecedentePatologicoPersonalDTO> findByAntecedente(Long idAntecedente) {
        return null;
    }
}

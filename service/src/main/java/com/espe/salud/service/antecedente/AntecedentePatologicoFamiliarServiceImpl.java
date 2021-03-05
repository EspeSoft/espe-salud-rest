package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;
import com.espe.salud.mapper.antecedente.AntecedentePatologicoFamiliarMapper;
import com.espe.salud.persistence.antecedente.AntecedentePatologicoFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedentePatologicoFamiliarServiceImpl implements AntecedentePatologicoFamiliarService {

    private final AntecedentePatologicoFamiliarRepository domainRepository;
    private final AntecedentePatologicoFamiliarMapper mapper;

    @Autowired
    public AntecedentePatologicoFamiliarServiceImpl(AntecedentePatologicoFamiliarRepository domainRepository, AntecedentePatologicoFamiliarMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AntecedentePatologicoFamiliarDTO save(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO) {
        Optional<AntecedentePatologicoFamiliar> optional = domainRepository.findByCodigo(antecedentePatologicoFamiliaDTO.getId());
        if (optional.isEmpty()) {
            AntecedentePatologicoFamiliar domainObject = mapper.toAntecedentePatologicoFamiliar(antecedentePatologicoFamiliaDTO);
            return mapper.toAntecedentePatologicoFamiliarDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe un antecedente patológico familiar para ese ID");
        }
    }

    @Override
    @Transactional
    public AntecedentePatologicoFamiliarDTO update(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO) {
        AntecedentePatologicoFamiliar domainObject = mapper.toAntecedentePatologicoFamiliar(antecedentePatologicoFamiliaDTO);
        return mapper.toAntecedentePatologicoFamiliarDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedentePatologicoFamiliarDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(mapper::toAntecedentePatologicoFamiliarDTO);
    }

    @Override
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(antecedentePatologicoFamiliar -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AntecedentePatologicoFamiliarDTO> findByPaciente(Long idPaciente) {
        return mapper.toAntecedentesPatologicoFamiliarDTO(domainRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}
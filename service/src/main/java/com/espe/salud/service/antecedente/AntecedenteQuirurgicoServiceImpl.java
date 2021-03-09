package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import com.espe.salud.mapper.antecedente.AntecedenteQuirurgicoMapper;
import com.espe.salud.persistence.antecedente.AntecedenteQuirurgicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedenteQuirurgicoServiceImpl implements AntecedenteQuirurgicoService {

    private final AntecedenteQuirurgicoRepository domainRepository;
    private final AntecedenteQuirurgicoMapper mapper;

    @Autowired
    public AntecedenteQuirurgicoServiceImpl(AntecedenteQuirurgicoRepository domainRepository, AntecedenteQuirurgicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AntecedenteQuirurgicoDTO save(AntecedenteQuirurgicoDTO dto) {
        Optional<AntecedenteQuirurgico> optional = domainRepository.findByCodigo(dto.getId());
        if (optional.isEmpty()) {
            AntecedenteQuirurgico domainObject = mapper.toAntecedenteQuirurgico(dto);
            return mapper.toAntecedenteQuirurgicoDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException("Ya existe un antecedente quirurgico para ese ID");
        }
    }

    @Override
    @Transactional
    public AntecedenteQuirurgicoDTO update(AntecedenteQuirurgicoDTO dto) {
        AntecedenteQuirurgico domainObject = mapper.toAntecedenteQuirurgico(dto);
        return mapper.toAntecedenteQuirurgicoDTO(domainRepository.save(domainObject));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AntecedenteQuirurgicoDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(mapper::toAntecedenteQuirurgicoDTO);
    }

    @Override
    @Transactional
    public boolean deleteById(Long codigo) {
        return domainRepository.findById(codigo).map(antecedenteQuirurgico -> {
            domainRepository.deleteById(codigo);
            return true;
        }).orElse(false);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AntecedenteQuirurgicoDTO> findByPaciente(Long idPaciente) {
        return mapper.toAntecedentesQuirurgicoDTO(domainRepository.findByAntecedentePersonalPacienteCodigo(idPaciente));
    }
}

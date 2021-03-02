package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import com.espe.salud.mapper.antecedente.AntecedenteQuirurgicoMapper;
import com.espe.salud.persistence.antecedente.AntecedenteQuirurgicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AntecedenteQuirurgicoDTO save(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO) {
        Optional<AntecedenteQuirurgico> optional = domainRepository.findById(antecedenteQuirurgicoDTO.getId());
        if (!optional.isEmpty()) {
            AntecedenteQuirurgico domainObject = toEntity(antecedenteQuirurgicoDTO);
            return toDTO(domainRepository.save(domainObject));
        } else {
            throw new ConflictException(String.format("Ya existe un antecedente quirurgico con el codigo [%s]", antecedenteQuirurgicoDTO.getId()));
        }
    }

    @Override
    public AntecedenteQuirurgicoDTO update(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO) {
        AntecedenteQuirurgico domainObject = toEntity(antecedenteQuirurgicoDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteQuirurgicoDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(antecedenteQuirurgico -> toDTO(antecedenteQuirurgico));
    }

    @Override
    public List<AntecedenteQuirurgicoDTO> findAll() {

        return mapper.toAntecedenteQuirurgicoDTO(domainRepository.findAll());
    }

    @Override
    public boolean deleteById(Long codigo) {
        return domainRepository.findById(codigo).map(antecedenteQuirurgico -> {
            domainRepository.deleteById(codigo);
            return true;
        }).orElse(false);
    }

    @Override
    public AntecedenteQuirurgicoDTO toDTO(AntecedenteQuirurgico antecedenteQuirurgico) {
        return mapper.toAntecedenteQuirurgicoDTO(antecedenteQuirurgico);
    }

    @Override
    public AntecedenteQuirurgico toEntity(AntecedenteQuirurgicoDTO dto) {
        return mapper.toAntecedenteQuirurgico(dto);
    }
}

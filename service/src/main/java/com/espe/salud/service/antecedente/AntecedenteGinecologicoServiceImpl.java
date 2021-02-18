package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedenteGinecologico;
import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import com.espe.salud.mapper.antecedente.AntecedenteGinecologicoMapper;
import com.espe.salud.persistence.antecedente.AntecedenteGinecologicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedenteGinecologicoServiceImpl implements AntecedenteGinecologicoService{

    private final AntecedenteGinecologicoRepository domainRepository;
    private final AntecedenteGinecologicoMapper mapper;

    @Autowired
    public AntecedenteGinecologicoServiceImpl(AntecedenteGinecologicoRepository domainRepository, AntecedenteGinecologicoMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public AntecedenteGinecologicoDTO save(AntecedenteGinecologicoDTO antecedenteGinecologicoDTO) {
        Optional<AntecedenteGinecologico> optional=domainRepository.findById(antecedenteGinecologicoDTO.getId());
        if (!optional.isPresent()){
            AntecedenteGinecologico domainObject=toEntity(antecedenteGinecologicoDTO);
            return toDTO(domainRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un antecedente ginecológico para el codigo [%s]",antecedenteGinecologicoDTO.getId()));
        }
    }

    @Override
    public AntecedenteGinecologicoDTO update(AntecedenteGinecologicoDTO antecedenteGinecologicoDTO) {
        AntecedenteGinecologico domainObject=toEntity(antecedenteGinecologicoDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<AntecedenteGinecologicoDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(antecedenteGinecologico -> toDTO(antecedenteGinecologico));
    }

    @Override
    public List<AntecedenteGinecologicoDTO> findAll() {
        return mapper.toAntecedenteGinecologicoDTO(domainRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(antecedenteGinecologico -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public AntecedenteGinecologicoDTO toDTO(AntecedenteGinecologico antecedenteGinecologico) {
        return mapper.toAntecedenteGinecologicoDTO(antecedenteGinecologico);
    }

    @Override
    public AntecedenteGinecologico toEntity(AntecedenteGinecologicoDTO dto) {
        return mapper.toAntecedenteGinecologico(dto);
    }
}

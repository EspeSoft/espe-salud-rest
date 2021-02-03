package com.espe.salud.service.antecedente;

import com.espe.salud.common.exception.ConflictException;
import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliaDTO;
import com.espe.salud.mapper.antecedente.AntecedentePatologicoFamiliarMapper;
import com.espe.salud.persistence.antecedente.AntecedentePatologicoFamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntecedentePatologicoFamiliarServiceImpl implements AntecedentePatologicoFamiliarService{

    private final AntecedentePatologicoFamiliarRepository domainRepository;
    private final AntecedentePatologicoFamiliarMapper mapper;

    @Autowired
    public AntecedentePatologicoFamiliarServiceImpl(AntecedentePatologicoFamiliarRepository domainRepository, AntecedentePatologicoFamiliarMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public AntecedentePatologicoFamiliaDTO save(AntecedentePatologicoFamiliaDTO antecedentePatologicoFamiliaDTO) {
        Optional<AntecedentePatologicoFamiliar> optional=domainRepository.findById(antecedentePatologicoFamiliaDTO.getId());
        if (!optional.isPresent()){
            AntecedentePatologicoFamiliar domainObject=toEntity(antecedentePatologicoFamiliaDTO);
            return toDTO(domainRepository.save(domainObject));
        }else{
            throw new ConflictException(String.format("Ya existe un antecedente patologico familiar para el codigo [%s]",antecedentePatologicoFamiliaDTO.getId()));
        }
    }

    @Override
    public AntecedentePatologicoFamiliaDTO update(AntecedentePatologicoFamiliaDTO antecedentePatologicoFamiliaDTO) {
        AntecedentePatologicoFamiliar domainObject=toEntity(antecedentePatologicoFamiliaDTO);
        return toDTO(domainRepository.save(domainObject));
    }

    @Override
    public Optional<AntecedentePatologicoFamiliaDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(antecedentePatologicoFamiliar -> toDTO(antecedentePatologicoFamiliar));
    }

    @Override
    public List<AntecedentePatologicoFamiliaDTO> findAll() {
        return mapper.toAntecedentePatologicoFamiliarDTO(domainRepository.findAll());
    }

    @Override
    public boolean deleteById(Long id) {
        return domainRepository.findById(id).map(antecedentePatologicoFamiliar -> {
            domainRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    @Override
    public AntecedentePatologicoFamiliaDTO toDTO(AntecedentePatologicoFamiliar antecedentePatologicoFamiliar) {
        return mapper.toAntecedentePatologicoFamiliarDTO(antecedentePatologicoFamiliar);
    }

    @Override
    public AntecedentePatologicoFamiliar toEntity(AntecedentePatologicoFamiliaDTO dto) {
        return mapper.toAntecedentePatologicoFamiliar(dto);
    }
}

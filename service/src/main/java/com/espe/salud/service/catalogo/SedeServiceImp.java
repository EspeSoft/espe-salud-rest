package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.Sede;
import com.espe.salud.dto.catalogo.SedeDTO;
import com.espe.salud.mapper.catalogo.SedeMapper;
import com.espe.salud.persistence.catalogo.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeServiceImp implements SedeService{

    private final SedeRepository domainRepository;
    private final SedeMapper mapper;

    @Autowired
    public SedeServiceImp(SedeRepository domainRepository, SedeMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<SedeDTO> findById(Long codigo) {
        return domainRepository.findById(codigo).map(sede -> toDTO(sede));
    }

    @Override
    public List<SedeDTO> findAll() {
        return mapper.toSedeDTO(domainRepository.findAll());
    }

    @Override
    public SedeDTO toDTO(Sede sede) {
        return mapper.toSedeDTO(sede);
    }

    @Override
    public Sede toEntity(SedeDTO dto) {
        return mapper.toSede(dto);
    }
}

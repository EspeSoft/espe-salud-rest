package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoCultural;
import com.espe.salud.dto.catalogo.GrupoCulturalDTO;
import com.espe.salud.mapper.catalogo.GrupoCulturalMapper;
import com.espe.salud.persistence.catalogo.GrupoCulturalRepository;
import com.espe.salud.service.GenericCRUDServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoCulturalServiceImpl implements GrupoCulturalService {
    private final GrupoCulturalRepository domainRepository;
    private final GrupoCulturalMapper mapper;

    @Autowired
    public GrupoCulturalServiceImpl(GrupoCulturalRepository domainRepository, GrupoCulturalMapper mapper) {
        this.domainRepository = domainRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<GrupoCulturalDTO> findById(Long codigo) {
        return domainRepository.findByCodigo(codigo).map(grupoCultural -> toDTO(grupoCultural));
    }

    @Override
    public List<GrupoCulturalDTO> findAll() {
        return mapper.toGrupoCulturalDTO(domainRepository.findAll());
    }

    @Override
    public GrupoCulturalDTO toDTO(GrupoCultural grupoCultural) {
        return mapper.toGrupoCulturalDTO(grupoCultural);
    }

    @Override
    public GrupoCultural toEntity(GrupoCulturalDTO dto) {
        return mapper.toGrupoCultural(dto);
    }
}

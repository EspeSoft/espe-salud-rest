package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIUO;
import com.espe.salud.dto.catalogo.CodigoCIUODTO;

import java.util.List;
import java.util.Optional;

public interface CodigoCIUOService {
    List<CodigoCIUODTO> findAll();

    List<CodigoCIUODTO> findByCodigoOrDescription(String query);

    Optional<CodigoCIUODTO> findById(String id);

    CodigoCIUODTO save(CodigoCIUODTO codigoCIUO);

    CodigoCIUODTO toDTO(CodigoCIUO codigoCIUO);

    CodigoCIUO toEntity(CodigoCIUODTO dto);
}

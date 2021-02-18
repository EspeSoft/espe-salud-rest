package com.espe.salud.service.catalogo;

import com.espe.salud.dto.catalogo.GrupoEnfermedadDTO;

import java.util.List;
import java.util.Optional;

public interface GrupoEnfermedadService {
    Optional<GrupoEnfermedadDTO> findById(String id);

    GrupoEnfermedadDTO save(GrupoEnfermedadDTO grupoEnfermedadDTO);

    List<GrupoEnfermedadDTO> findAll();
}

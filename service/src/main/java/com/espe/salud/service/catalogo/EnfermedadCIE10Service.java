package com.espe.salud.service.catalogo;

import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;

import java.util.List;
import java.util.Optional;

public interface EnfermedadCIE10Service {
    Optional<EnfermedadCIE10DTO> findById(String id);

    EnfermedadCIE10DTO save(EnfermedadCIE10DTO enfermedadCIE10DTO);

    List<EnfermedadCIE10DTO> findByCodigoOrNombre(String query);

    List<EnfermedadCIE10DTO> findAll();
}

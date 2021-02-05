package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoPlanificacionFamiliar;
import com.espe.salud.dto.catalogo.TipoPlanificacionFamiliarDTO;

import java.util.List;
import java.util.Optional;

public interface TipoPlanificacionFamiliarService {
    TipoPlanificacionFamiliarDTO save(TipoPlanificacionFamiliarDTO dto);
    List<TipoPlanificacionFamiliarDTO> findAll();
    Optional<TipoPlanificacionFamiliarDTO> findById(Long id);
    List<TipoPlanificacionFamiliarDTO> findAllMujeres();
    List<TipoPlanificacionFamiliarDTO> findAllHombres();
    TipoPlanificacionFamiliarDTO toDTO(TipoPlanificacionFamiliar planificacionFamiliar);
    TipoPlanificacionFamiliar toEntity(TipoPlanificacionFamiliarDTO dto);
}

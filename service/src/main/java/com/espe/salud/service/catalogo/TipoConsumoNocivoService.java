package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoConsumoNocivo;
import com.espe.salud.dto.catalogo.TipoConsumoNocivoDTO;

import java.util.List;
import java.util.Optional;

public interface TipoConsumoNocivoService {
    Optional<TipoConsumoNocivoDTO> findById(Long id);

    List<TipoConsumoNocivoDTO> findAllOrderByNombreASC();

    TipoConsumoNocivoDTO save(TipoConsumoNocivoDTO tipoConsumoNocivoDTO);

    List<TipoConsumoNocivoDTO> findByNombreStartingWith(String nombre);

    TipoConsumoNocivoDTO toDTO(TipoConsumoNocivo tipoConsumoNocivo);

    TipoConsumoNocivo toEntity(TipoConsumoNocivoDTO dto);
}

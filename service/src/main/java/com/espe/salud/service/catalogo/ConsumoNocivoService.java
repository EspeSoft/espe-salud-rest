package com.espe.salud.service.catalogo;

import com.espe.salud.domain.entities.catalogo.ConsumoNocivo;
import com.espe.salud.dto.catalogo.ConsumoNocivoDTO;

import java.util.List;
import java.util.Optional;

public interface ConsumoNocivoService {
    Optional<ConsumoNocivoDTO> findById(Long id);

    List<ConsumoNocivoDTO> findAllOrderByNombreASC();

    ConsumoNocivoDTO save(ConsumoNocivoDTO consumoNocivoDTO);

    List<ConsumoNocivoDTO> findByNombreStartingWith(String nombre);

    ConsumoNocivoDTO toDTO(ConsumoNocivo consumoNocivo);

    ConsumoNocivo toEntity(ConsumoNocivoDTO dto);
}

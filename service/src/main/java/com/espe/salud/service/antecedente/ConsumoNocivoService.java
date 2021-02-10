package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.ConsumoNocivo;
import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;

import java.util.List;
import java.util.Optional;

public interface ConsumoNocivoService {
    ConsumoNocivoDTO save(ConsumoNocivoDTO consumoNocivo);
    ConsumoNocivoDTO update(ConsumoNocivoDTO consumoNocivo);
    Optional<ConsumoNocivo> findExisting(ConsumoNocivoDTO pacienteDTO);
    Boolean delete(Long id);
    Optional<ConsumoNocivoDTO> findByCodigo(Long codigo);
    ConsumoNocivoDTO toDTO(ConsumoNocivo consumoNocivo);
    ConsumoNocivo toEntity(ConsumoNocivoDTO dto);
    List<ConsumoNocivoDTO> findAll();
}


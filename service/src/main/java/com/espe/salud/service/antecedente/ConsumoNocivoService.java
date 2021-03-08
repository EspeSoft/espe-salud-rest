package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.ConsumoNocivoDTO;

import java.util.List;
import java.util.Optional;

public interface ConsumoNocivoService {
    ConsumoNocivoDTO save(ConsumoNocivoDTO dto);

    ConsumoNocivoDTO update(ConsumoNocivoDTO dto);

    Optional<ConsumoNocivoDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<ConsumoNocivoDTO> findByPaciente(Long idPaciente);
}


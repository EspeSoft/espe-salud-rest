package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.DiscapacidadDTO;

import java.util.List;
import java.util.Optional;

public interface DiscapacidadService {
    DiscapacidadDTO save(DiscapacidadDTO dto);

    DiscapacidadDTO update(DiscapacidadDTO dto);

    Optional<DiscapacidadDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<DiscapacidadDTO> findByPaciente(Long idPaciente);
}

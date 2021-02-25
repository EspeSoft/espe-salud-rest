package com.espe.salud.service.examen;

import com.espe.salud.dto.examen.ExamenExternoDTO;

import java.util.List;
import java.util.Optional;

public interface ExamenExternoService {
    ExamenExternoDTO save(ExamenExternoDTO dto);
    Optional<ExamenExternoDTO> findById(Long id);
    List<ExamenExternoDTO> findByPaciente(Long idPaciente);
    ExamenExternoDTO update(ExamenExternoDTO dto);
    boolean delete(Long codigo);
}

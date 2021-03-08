package com.espe.salud.service.examen;

import com.espe.salud.dto.examen.ExamenInternoDTO;

import java.util.List;
import java.util.Optional;

public interface ExamenInternoService {
    ExamenInternoDTO save(ExamenInternoDTO dto);

    Optional<ExamenInternoDTO> findById(Long id);

    List<ExamenInternoDTO> findByPaciente(Long idPaciente);

    ExamenInternoDTO update(ExamenInternoDTO dto);

    boolean delete(Long codigo);
}

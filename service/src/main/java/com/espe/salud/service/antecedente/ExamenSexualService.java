package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.ExamenSexualDTO;

import java.util.List;
import java.util.Optional;

public interface ExamenSexualService {

    ExamenSexualDTO save(ExamenSexualDTO dto);

    ExamenSexualDTO update(ExamenSexualDTO dto);

    Optional<ExamenSexualDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<ExamenSexualDTO> findByPaciente(Long idPaciente);

}

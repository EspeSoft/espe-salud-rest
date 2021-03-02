package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.EstudioComplementarioDTO;

import java.util.List;
import java.util.Optional;

public interface EstudioComplementarioService {
    EstudioComplementarioDTO save(EstudioComplementarioDTO estudioComplementarioDTO);

    EstudioComplementarioDTO update(EstudioComplementarioDTO estudioComplementarioDTO);

    Optional<EstudioComplementarioDTO> findById(Long codigo);

    boolean delete(Long codigo);

    List<EstudioComplementarioDTO> findByPaciente(Long idPaciente);
}

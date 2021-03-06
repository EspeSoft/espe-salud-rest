package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteQuirurgicoService {
    AntecedenteQuirurgicoDTO save(AntecedenteQuirurgicoDTO dto);

    AntecedenteQuirurgicoDTO update(AntecedenteQuirurgicoDTO dto);

    Optional<AntecedenteQuirurgicoDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<AntecedenteQuirurgicoDTO> findByPaciente(Long idPaciente);
}

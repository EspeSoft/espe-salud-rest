package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;

import java.util.Optional;

public interface AntecedentePersonalService {
    AntecedentePersonalDTO save(AntecedentePersonalDTO antecedentePersonal);

    AntecedentePersonalDTO update(AntecedentePersonalDTO antecedentePersonal);

    Optional<AntecedentePersonalDTO> findById(Long id);

    Optional<AntecedentePersonalDTO> findByPaciente(Long idPaciente);
}

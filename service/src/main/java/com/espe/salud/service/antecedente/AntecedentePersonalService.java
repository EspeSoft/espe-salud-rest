package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePersonal;
import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedentePersonalService {

    AntecedentePersonalDTO save(AntecedentePersonalDTO antecedentePersonal);
    AntecedentePersonalDTO update(AntecedentePersonalDTO antecedentePersonal);
    Optional<AntecedentePersonal> findExisting(AntecedentePersonalDTO antecedentePersonalDTO);
    Boolean delete(Long id);
    Optional<AntecedentePersonalDTO> findByCodigo(Long codigo);
    AntecedentePersonalDTO toDTO(AntecedentePersonal antecedentePersonal);
    AntecedentePersonal toEntity(AntecedentePersonalDTO dto);
    List<AntecedentePersonalDTO> findAll();
}

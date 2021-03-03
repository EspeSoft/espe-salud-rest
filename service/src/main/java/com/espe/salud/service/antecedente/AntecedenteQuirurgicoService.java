package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteQuirurgicoService {
    AntecedenteQuirurgicoDTO save(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO);
    AntecedenteQuirurgicoDTO update(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO);
    Optional<AntecedenteQuirurgicoDTO> findById(Long codigo);
    List<AntecedenteQuirurgicoDTO> findAll();
    List<AntecedenteQuirurgicoDTO> findByIdAntecedente(Long idAntecedente);
    boolean deleteById(Long codigo);
    AntecedenteQuirurgicoDTO toDTO(AntecedenteQuirurgico antecedenteQuirurgico);
    AntecedenteQuirurgico toEntity(AntecedenteQuirurgicoDTO dto);
}

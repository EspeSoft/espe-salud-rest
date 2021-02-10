package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AntecedenteQuirurgicoService {
    AntecedenteQuirurgicoDTO save(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO);
    AntecedenteQuirurgicoDTO update(AntecedenteQuirurgicoDTO antecedenteQuirurgicoDTO);
    Optional<AntecedenteQuirurgicoDTO> findById(Long codigo);
    List<AntecedenteQuirurgicoDTO> findAll();
    boolean deleteById(Long codigo);
    AntecedenteQuirurgicoDTO toDTO(AntecedenteQuirurgico antecedenteQuirurgico);
    AntecedenteQuirurgico toEntity(AntecedenteQuirurgicoDTO dto);
}

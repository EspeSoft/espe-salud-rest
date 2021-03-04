package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteGinecologico;
import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AntecedenteGinecologicoService {
    AntecedenteGinecologicoDTO save(AntecedenteGinecologicoDTO antecedenteGinecologicoDTO);

    AntecedenteGinecologicoDTO update(AntecedenteGinecologicoDTO antecedenteGinecologicoDTO);

    Optional<AntecedenteGinecologicoDTO> findById(Long codigo);

    List<AntecedenteGinecologicoDTO> findAll();

    boolean deleteById(Long id);

    AntecedenteGinecologicoDTO toDTO(AntecedenteGinecologico antecedenteGinecologico);

    AntecedenteGinecologico toEntity(AntecedenteGinecologicoDTO dto);
}
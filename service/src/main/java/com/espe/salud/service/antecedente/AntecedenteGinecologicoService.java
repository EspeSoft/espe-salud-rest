package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteGinecologicoService {
    AntecedenteGinecologicoDTO save(AntecedenteGinecologicoDTO dto);

    AntecedenteGinecologicoDTO update(AntecedenteGinecologicoDTO dto);

    Optional<AntecedenteGinecologicoDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<AntecedenteGinecologicoDTO> findByPaciente(Long idPaciente);
}
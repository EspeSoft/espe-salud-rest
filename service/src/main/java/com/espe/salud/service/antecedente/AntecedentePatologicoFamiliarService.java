package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedentePatologicoFamiliarService {
    AntecedentePatologicoFamiliarDTO save(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO);
    AntecedentePatologicoFamiliarDTO update(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO);
    Optional<AntecedentePatologicoFamiliarDTO> findById(Long codigo);
    List<AntecedentePatologicoFamiliarDTO> findAll();
    boolean deleteById(Long id);
    AntecedentePatologicoFamiliarDTO toDTO(AntecedentePatologicoFamiliar antecedentePatologicoFamiliar);
    AntecedentePatologicoFamiliar toEntity(AntecedentePatologicoFamiliarDTO dto);
}

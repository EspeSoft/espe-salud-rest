package com.espe.salud.service.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AntecedentePatologicoFamiliarService {
    AntecedentePatologicoFamiliaDTO save(AntecedentePatologicoFamiliaDTO antecedentePatologicoFamiliaDTO);
    AntecedentePatologicoFamiliaDTO update(AntecedentePatologicoFamiliaDTO antecedentePatologicoFamiliaDTO);
    Optional<AntecedentePatologicoFamiliaDTO> findById(Long codigo);
    List<AntecedentePatologicoFamiliaDTO> findAll();
    boolean deleteById(Long id);
    AntecedentePatologicoFamiliaDTO toDTO(AntecedentePatologicoFamiliar antecedentePatologicoFamiliar);
    AntecedentePatologicoFamiliar toEntity(AntecedentePatologicoFamiliaDTO dto);
}

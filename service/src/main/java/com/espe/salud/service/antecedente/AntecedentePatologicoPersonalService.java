package com.espe.salud.service.antecedente;


import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoPersonal;
import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AntecedentePatologicoPersonalService {
    AntecedentePatologicoPersonalDTO save(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO);
    AntecedentePatologicoPersonalDTO update(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO);
    Optional<AntecedentePatologicoPersonalDTO> findById(Long codigo);
    List<AntecedentePatologicoPersonalDTO> findAll();
    boolean deleteById(Long id);
    AntecedentePatologicoPersonalDTO toDTO(AntecedentePatologicoPersonal antecedentePatologicoPersonal);
    AntecedentePatologicoPersonal toEntity(AntecedentePatologicoPersonalDTO dto);
}

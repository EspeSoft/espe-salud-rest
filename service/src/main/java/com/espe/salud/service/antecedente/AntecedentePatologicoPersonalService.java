package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedentePatologicoPersonalService {
    AntecedentePatologicoPersonalDTO save(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO);

    AntecedentePatologicoPersonalDTO update(AntecedentePatologicoPersonalDTO antecedentePatologicoPersonalDTO);

    Optional<AntecedentePatologicoPersonalDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<AntecedentePatologicoPersonalDTO> findByPaciente(Long idPaciente);
}

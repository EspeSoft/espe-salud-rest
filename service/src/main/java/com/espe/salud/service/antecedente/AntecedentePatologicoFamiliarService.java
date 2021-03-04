package com.espe.salud.service.antecedente;

import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedentePatologicoFamiliarService {
    AntecedentePatologicoFamiliarDTO save(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO);

    AntecedentePatologicoFamiliarDTO update(AntecedentePatologicoFamiliarDTO antecedentePatologicoFamiliaDTO);

    Optional<AntecedentePatologicoFamiliarDTO> findById(Long codigo);

    boolean deleteById(Long id);

    List<AntecedentePatologicoFamiliarDTO> findByPaciente(Long idPaciente);
}

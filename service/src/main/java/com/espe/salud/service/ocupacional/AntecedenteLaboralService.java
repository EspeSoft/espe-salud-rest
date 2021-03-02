package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteLaboralService {
    AntecedenteLaboralDTO save(AntecedenteLaboralDTO antecedente);

    AntecedenteLaboralDTO update(AntecedenteLaboralDTO antecedente);

    Boolean delete(Long id);

    Optional<AntecedenteLaboralDTO> findByCodigo(Long codigo);

    Optional<AntecedenteLaboralDTO> findByPaciente(Long idPaciente);

    AntecedenteLaboralDTO toDTO(AntecedenteLaboral antecedente);

    AntecedenteLaboral toEntity(AntecedenteLaboralDTO dto);
}

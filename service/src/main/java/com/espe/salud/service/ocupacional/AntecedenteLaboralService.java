package com.espe.salud.service.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;

import java.util.List;
import java.util.Optional;

public interface AntecedenteLaboralService {
    AntecedenteLaboralDTO save  (AntecedenteLaboralDTO antecedente);
    AntecedenteLaboralDTO update(AntecedenteLaboralDTO antecedente);
    Optional<AntecedenteLaboral> findExisting(AntecedenteLaboralDTO antecedenteDTO);
    Boolean delete(Long id);
    Optional<AntecedenteLaboralDTO > findByCodigo(Long codigo);
    AntecedenteLaboralDTO  toDTO (AntecedenteLaboral antecedente);
    AntecedenteLaboral toEntity (AntecedenteLaboralDTO dto);
    List<AntecedenteLaboralDTO> findAll();
}
